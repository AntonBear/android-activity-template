package com.anton.android_app_template

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anton.android_app_template.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonGoToFragment.setOnClickListener {
            findNavController().navigate(R.id.action_first_to_third)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentLifeCycle", "onAttach()")
        logFragmentManager()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentLifeCycle", "onCreate()")
        logFragmentManager()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Log.d("FragmentLifeCycle", "onStart()")
        logFragmentManager()
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentLifeCycle", "onResume()")
        logFragmentManager()
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentLifeCycle", "onPause()")
        logFragmentManager()
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragmentLifeCycle", "onStop()")
        logFragmentManager()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentLifeCycle", "onDestroyView()")
        logFragmentManager()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentLifeCycle", "onDestroy()")
        logFragmentManager()
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentLifeCycle", "onDetach()")
        logFragmentManager()
    }

    private fun logFragmentManager() {
        val fragments = parentFragmentManager.fragments.map { it::class.java.simpleName }
        Log.d("FragmentManagerState", "Сейчас во FragmentManager: $fragments")
    }
}