package com.example.testproject.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.testproject.R
import com.example.testproject.application.component
import com.example.testproject.data.User
import com.example.testproject.ui.FragmentsUIState
import com.example.testproject.ui.UsersViewModel
import com.example.testproject.ui.UsersViewModelFactory
import javax.inject.Inject

class UserInfoFragment : Fragment(R.layout.fragment_user_info) {

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

        val progressBar = requireActivity().findViewById<ProgressBar>(R.id.info_fr_progress_bar)

        vm.fragmentsUIState.observe(viewLifecycleOwner) {

            when (it) {

                FragmentsUIState.Success -> {
                    progressBar.visibility = View.GONE
                    bindData(vm.currentUser!!)
                }

                FragmentsUIState.Loading -> {
                    progressBar.visibility = View.VISIBLE
                }

                FragmentsUIState.Error -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(
                        requireContext(),
                        FragmentsUIState.Error.userInfoErrorMessage,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }

    private fun bindData(user: User) {

        requireActivity().findViewById<TextView>(R.id.plain_text_id).visibility = View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.plain_text_address).visibility = View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.plain_text_job).visibility = View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.plain_text_contacts).visibility = View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.plain_text_lng).visibility = View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.plain_text_lat).visibility = View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.plain_text_user_main_info).visibility =
            View.VISIBLE
        requireActivity().findViewById<TextView>(R.id.plain_text_username).visibility = View.VISIBLE

        requireActivity().findViewById<TextView>(R.id.tv_name).text = user.name
        requireActivity().findViewById<TextView>(R.id.tv_user_id).text = user.id.toString()
        requireActivity().findViewById<TextView>(R.id.tv_username).text = user.username
        requireActivity().findViewById<TextView>(R.id.tv_email).text = user.email
        requireActivity().findViewById<TextView>(R.id.tv_phone).text = user.phone
        requireActivity().findViewById<TextView>(R.id.tv_web).text = user.website

        val address = user.address
        requireActivity().findViewById<TextView>(R.id.tv_str).text = address.street
        requireActivity().findViewById<TextView>(R.id.tv_city).text = address.city
        requireActivity().findViewById<TextView>(R.id.tv_suite).text = address.suite
        requireActivity().findViewById<TextView>(R.id.tv_zip).text = address.zipcode
        requireActivity().findViewById<TextView>(R.id.tv_lat).text = address.geo.lat
        requireActivity().findViewById<TextView>(R.id.tv_lng).text = address.geo.lng

        val comp = user.company
        requireActivity().findViewById<TextView>(R.id.tv_comp_name).text = comp.name
        requireActivity().findViewById<TextView>(R.id.tv_comp_catch).text = comp.catchPhrase
        requireActivity().findViewById<TextView>(R.id.tv_comp_bs).text = comp.bs
    }
}