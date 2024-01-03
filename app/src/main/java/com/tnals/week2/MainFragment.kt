package com.tnals.week2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.tnals.week2.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = requireNotNull(_binding) { "null" }
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val user = arguments?.getParcelable<User>("user_data")
        val peopleAdapter = PeopleAdapter(requireContext())
        binding.rvHumans.adapter = peopleAdapter
        if (user != null)
            peopleAdapter.setPeopleList(viewModel.makeList(user))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun scrollToTop(){
        binding.rvHumans.smoothScrollToPosition(0)
    }
}