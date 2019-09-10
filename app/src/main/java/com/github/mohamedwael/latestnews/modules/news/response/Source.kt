package com.github.mohamedwael.latestnews.modules.news.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Source(

	@field:SerializedName("name")
	val name: String? = null
):Serializable