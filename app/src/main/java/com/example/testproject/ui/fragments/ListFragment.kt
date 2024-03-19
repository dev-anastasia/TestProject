package com.example.testproject.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testproject.R
import com.example.testproject.ui.adapter.ClickListener
import com.example.testproject.ui.adapter.UsersAdapter
import com.example.testproject.application.component
import com.example.testproject.ui.UsersUIState
import com.example.testproject.ui.UsersViewModel
import com.example.testproject.ui.UsersViewModelFactory
import javax.inject.Inject

class ListFragment : Fragment(R.layout.fragment_list), ClickListener {

    @Inject
    lateinit var vmFactory: UsersViewModelFactory
    private lateinit var vm: UsersViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        requireContext().component.inject(this)
        vm = ViewModelProvider(requireActivity(), vmFactory)[UsersViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = requireActivity().findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false
        )
        val adapter = UsersAdapter(this)
        recyclerView.adapter = adapter

        val progressBar = requireActivity().findViewById<ProgressBar>(R.id.list_fr_progress_bar)

        vm.uiState.observe(viewLifecycleOwner) {
            when (it) {

                UsersUIState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                UsersUIState.Success -> {
                    adapter.updateList(vm.usersList)
                    progressBar.visibility = View.GONE
                }

                UsersUIState.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(), UsersUIState.Error.listErrorMessage, Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        if (vm.uiState.value == null) {
            vm.getUsersList()
        }
    }

    override fun onUserClicked(userId: Long) {
        vm.getUserInfo(userId)

        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, UserInfoFragment())
            .addToBackStack("added UserInfoFragment")
            .setReorderingAllowed(true)
            .commit()
    }
}