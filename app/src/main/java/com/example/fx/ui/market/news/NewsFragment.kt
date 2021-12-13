package com.example.fx.ui.market.news

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fx.databinding.FragmentNewsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private var _binding: FragmentNewsBinding? = null

    private val binding get() = _binding!!

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNewsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        // TODO: Use the ViewModel
        Log.e("FRAGMENT", "NEWS")
        getNews("https://api.mitorg.net/mit-originalapps/htdocs/app/GetNewsTitles")

    }

    private fun getNews(apiUrl: String) {
        CoroutineScope(Dispatchers.IO).launch {
            Log.e("COROUTINE: ", "START")
            viewModel.getNews()
        }
    }

}