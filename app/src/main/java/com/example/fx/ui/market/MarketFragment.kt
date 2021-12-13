package com.example.fx.ui.market

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.fx.adapters.view_pager.ViewPagerAdapter
import com.example.fx.databinding.FragmentMarketBinding
import com.example.fx.ui.market.calendar.CalendarFragment
import com.example.fx.ui.market.news.NewsFragment
import com.google.android.material.tabs.TabLayoutMediator

class MarketFragment : Fragment() {

    companion object {
        fun newInstance() = MarketFragment()
    }

    private lateinit var viewModel: MarketViewModel
    private var _binding: FragmentMarketBinding? = null
    private val binding get() = _binding!!

    private val viewPager: ViewPager2
        get() {
            return binding.viewPager
        }

    private val tabLayout get() = binding.tabLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarketBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpTabs()
//        viewPager.post {
//            kotlin.run {
//                viewPager.currentItem = 1
//            }
//        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MarketViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(this)
        adapter.addFragment(NewsFragment(), "News")
        adapter.addFragment(CalendarFragment(), "Calendar")

        viewPager.adapter = adapter
//        tabLayout.setupWithViewPager(viewPager)
        TabLayoutMediator(tabLayout, viewPager) {
            tab, position ->
            when(position) {
                0 -> tab.text = adapter.getPageTitle(position)
                1 -> tab.text = adapter.getPageTitle(position)
            }
        }.attach()
    }
}