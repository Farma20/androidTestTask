package com.example.test_task.UI.View

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.test_task.UI.Model.PostModel
import com.example.test_task.databinding.FragmentPostBinding

class PostFragment : Fragment() {

    private var _binding: FragmentPostBinding? = null
    private val binding get() = _binding!!

    private lateinit var hostActivity: MainActivity
    private var postIndex: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPostBinding.inflate(inflater)
        postIndex = requireArguments().getInt("postIndex")
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        val currentPost: PostModel = hostActivity.mainMenuViewModel.allPosts.value!![postIndex]
        binding.postAuthor.text = "Пользователь ${currentPost.userId}"
        binding.postTitle.text = currentPost.title
        binding.postText.text = currentPost.body
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        hostActivity = context as MainActivity
    }
}