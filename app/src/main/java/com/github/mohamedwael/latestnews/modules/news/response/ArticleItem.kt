package com.github.mohamedwael.latestnews.modules.news.response

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.Nullable
import java.io.Serializable

@Entity(tableName = "articles")
data class ArticleItem(

    @Embedded
	@field:SerializedName("source")
	val source: Source? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

    @PrimaryKey
	@field:SerializedName("url")
	var url: String = "",

	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,

	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@field:SerializedName("content")
	val content: String? = null
):Serializable