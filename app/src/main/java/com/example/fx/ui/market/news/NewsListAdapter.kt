package com.example.fx.ui.market.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fx.databinding.NewsListItemViewBinding

class NewsListAdapter: RecyclerView.Adapter<NewsListAdapter.NewsListViewHolder>() {

    var data: List<String> = listOf()

    class NewsListViewHolder(binding: NewsListItemViewBinding): RecyclerView.ViewHolder(binding.root) {
        val newsDate = binding.newsDate
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsListViewHolder {
        return NewsListViewHolder(NewsListItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: NewsListViewHolder, position: Int) {
        val news = data[position]

    }

    override fun getItemCount(): Int {
       return data.size
    }
}

