package com.github.mohamedwael.latestnews.modules.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.mohamedwael.latestnews.modules.news.response.ArticleItem
import com.github.mohamedwael.latestnews.modules.wedgits.NewsItemView

class NewsAdapter :
    PagedListAdapter<ArticleItem, NewsAdapter.GithubRepoViewHolder>(object :
        DiffUtil.ItemCallback<ArticleItem>() {
        override fun areItemsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: ArticleItem, newItem: ArticleItem): Boolean {
            return oldItem.publishedAt == newItem.publishedAt && oldItem.title == newItem.title
        }
    }) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
        return GithubRepoViewHolder(NewsItemView(parent.context))
    }

    override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
        if (getItem(position) != null) {
            (holder.itemView as NewsItemView).bind(getItem(position)!!)
        }
    }


    class GithubRepoViewHolder(view: NewsItemView) : RecyclerView.ViewHolder(view)
}