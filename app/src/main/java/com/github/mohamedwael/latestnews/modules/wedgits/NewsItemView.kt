package com.github.mohamedwael.latestnews.modules.wedgits

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.github.mohamedwael.latestnews.R
import com.github.mohamedwael.latestnews.applevel.formatTime
import com.github.mohamedwael.latestnews.applevel.getRelativeTime
import com.github.mohamedwael.latestnews.applevel.network.loadImage
import com.github.mohamedwael.latestnews.databinding.NewsItemViewBinding
import com.github.mohamedwael.latestnews.modules.news.response.ArticleItem

class NewsItemView : LinearLayout {

    lateinit var binding: NewsItemViewBinding

    constructor(context: Context) : super(context) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes) {
        initView(context)
    }

    private fun initView(context: Context) {
        binding = NewsItemViewBinding.inflate(LayoutInflater.from(context), this, true)
        layoutParams = LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT)
    }

    fun bind(item: ArticleItem) {
        binding.tvTitle.text = item.title
        binding.tvDescription.text = item.description
        binding.tvAuthor.text = item.source?.name
        if (!item.publishedAt.isNullOrEmpty()) {
            binding.tvDate.text = getRelativeTime(item.publishedAt)
        }
        if (item.urlToImage.isNullOrEmpty()) {
            binding.ivNewsImage.visibility = View.GONE
        } else {
            binding.ivNewsImage.visibility = View.VISIBLE
            loadImage(item.urlToImage, binding.ivNewsImage).error(R.mipmap.ic_launcher)
                .into(binding.ivNewsImage)
        }
    }
}