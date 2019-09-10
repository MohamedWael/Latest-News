package com.github.mohamedwael.latestnews.modules.news.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.github.mohamedwael.latestnews.R
import com.github.mohamedwael.latestnews.databinding.NewsFragmentBinding
import com.github.mohamedwael.latestnews.modules.adapter.NewsAdapter
import com.github.mohamedwael.latestnews.modules.news.viewmodel.NewsViewModel
import com.github.mohamedwael.latestnews.modules.news.viewmodel.NewsViewModelFactory

class NewsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsFragment()
    }

    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this, NewsViewModelFactory()).get(NewsViewModel::class.java)
        val binding = NewsFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.rvNews.layoutManager = LinearLayoutManager(context)
        binding.rvNews.adapter = NewsAdapter()
        observeOnLiveError()
        observeOnReposList(binding.rvNews.adapter as NewsAdapter)
        viewModel.getNews()
        return binding.root
    }

    private fun observeOnReposList(adapter: NewsAdapter) {

        viewModel.liveNewsList.observe(viewLifecycleOwner, Observer {
            viewModel.hideProgress()
            adapter.submitList(it)
        })
        adapter.registerAdapterDataObserver(object : RecyclerView.AdapterDataObserver() {
            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                viewModel.hideProgress()
            }
        })
    }

    private fun observeOnLiveError() {
        viewModel.errorHandler.observe(viewLifecycleOwner, Observer {
            viewModel.hideProgress()
            showMsg(if (it.errorMsgString.isNullOrEmpty()) getString(it.errorMsgStringRes) else it.errorMsgString)
        })
    }


    private fun showMsg(msgString: String) {
        Toast.makeText(context, msgString, Toast.LENGTH_LONG).show()
    }
}
