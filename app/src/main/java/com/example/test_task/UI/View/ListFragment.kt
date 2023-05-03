package com.example.test_task.UI.View

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test_task.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var hostActivity: MainActivity
    private lateinit var recyclerViewClass: ListFragmentRecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater)
        recyclerViewClass =  ListFragmentRecyclerView(inflater, binding.recyclerView)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        hostActivity.mainMenuViewModel.allPosts.observe(this){
            binding.progressBar.visibility = if (it.isEmpty())  View.VISIBLE else  View.GONE
            recyclerViewClass.onStart(hostActivity.mainMenuViewModel.allPosts.value!!)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        hostActivity = context as MainActivity
    }

}