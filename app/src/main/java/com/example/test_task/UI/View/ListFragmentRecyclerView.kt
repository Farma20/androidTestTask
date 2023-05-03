package com.example.test_task.UI.View

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.test_task.R
import com.example.test_task.UI.Model.PostModel

class ListFragmentRecyclerView(val inflater: LayoutInflater, private val recyclerView: RecyclerView) {
    fun onStart(allPosts: List<PostModel>) {
        recyclerView.adapter = RecyclerAdapter(allPosts)
    }

    private inner class RecyclerAdapter(val allPosts: List<PostModel>) :
        RecyclerView.Adapter<RecyclerViewHolder>(){

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
            val view =  inflater.inflate(R.layout.fragment_list_item, parent, false)
            view.setOnClickListener {
                val bundle = bundleOf("postIndex" to viewType)
                view.findNavController().navigate(R.id.action_listFragment_to_postFragment, bundle)
            }
            return RecyclerViewHolder(view)
        }

        @SuppressLint("SetTextI18n")
        override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
            holder.apply {
                postTitle.text = allPosts[position].title
                authorName.text = "Пользователь ${allPosts[position].userId}"
            }
        }

        override fun getItemCount(): Int = allPosts.size

        override fun getItemViewType(position: Int): Int {
            return position
        }
    }

    private inner class RecyclerViewHolder(view: View): RecyclerView.ViewHolder(view){
        val postTitle:TextView = itemView.findViewById(R.id.postTitle)
        val authorName:TextView = itemView.findViewById(R.id.postAuthor)
    }
}