package com.example.testtask.presentation.userList

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testtask.databinding.FragmentUserListBinding
import com.example.testtask.domain.model.UserDetails
import org.koin.androidx.viewmodel.ext.android.viewModel


class UserListFragment : Fragment(), UserListAdapter.ClickListener {
    private lateinit var binding: FragmentUserListBinding
    private lateinit var adapter: UserListAdapter
    private val viewModel by viewModel<UserListViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.getUserList()
        binding.btLoadUsers.setOnClickListener { viewModel.updateUserList() }
        viewModel.userList.observe(viewLifecycleOwner) { state ->
            when (state) {
                is UserUiState.Success -> {
                    binding.progress.visibility = View.GONE
                    adapter.map(state.users)
                }

                is UserUiState.Error -> Toast.makeText(
                    requireActivity(),
                    state.msg,
                    Toast.LENGTH_LONG
                ).show()

                is UserUiState.Loading -> binding.progress.visibility = View.VISIBLE
            }
        }
    }

    private fun initRecyclerView() = with(binding) {
        adapter = UserListAdapter(this@UserListFragment)
        rcViewUsers.layoutManager = LinearLayoutManager(requireContext())
        rcViewUsers.adapter = adapter
    }

    override fun click(userDetails: UserDetails) {
        userDetails.id?.let { id ->
            val action = UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(id)
            findNavController().navigate(action)
        }
    }
}