package com.example.themealsapp.data.rest.dto


import com.example.themealsapp.domain.model.Category
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CategoryInfoDto(
    @Json(name = "idCategory")
    val idCategory: String? = null,
    @Json(name = "strCategory")
    val strCategory: String? = null,
    @Json(name = "strCategoryDescription")
    val strCategoryDescription: String? = null,
    @Json(name = "strCategoryThumb")
    val strCategoryThumb: String? = null
) {

    fun toCategory(): Category {
        return Category(
            idCategory = idCategory  ?: "",
            strCategory = strCategory  ?: "",
            strCategoryDescription = strCategoryDescription ?: "",
            strCategoryThumb = strCategoryThumb ?: ""
        )
    }
}