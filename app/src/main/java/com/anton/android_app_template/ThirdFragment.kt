package com.anton.android_app_template

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.anton.android_app_template.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Кнопка перехода на FirstFragment
        binding.buttonToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_third_to_first)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onCreate()")
    }


    override fun onStart() {
        super.onStart()
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onResume()")
        logFragmentManager()
    }

    override fun onPause() {
        super.onPause()
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onStop()")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("FragmentLifeCycle", "${javaClass.simpleName}:onDetach()")
    }

    private fun logFragmentManager() {
        val fragments = parentFragmentManager.fragments.map { it::class.java.simpleName }
        Log.d("FragmentManagerState", "Сейчас во FragmentManager: $fragments")
    }


}
