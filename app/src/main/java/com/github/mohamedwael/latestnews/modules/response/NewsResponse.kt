package com.github.mohamedwael.latestnews.modules.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class NewsResponse(

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem?>? = null
):Serializable