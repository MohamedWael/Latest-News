package com.github.mohamedwael.latestnews.modules.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Source(

	@field:SerializedName("id")
	val id: Any? = null,

	@field:SerializedName("name")
	val name: String? = null
):Serializable