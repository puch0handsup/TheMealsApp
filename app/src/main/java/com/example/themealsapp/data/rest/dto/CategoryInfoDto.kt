package com.example.themealsapp.data.rest.dto


import com.example.themealsapp.domain.model.Category
import com.google.gson.annotations.SerializedName

data class CategoryInfoDto(
    @SerializedName("idCategory")
    val idCategory: String? = null,
    @SerializedName("strCategory")
    val strCategory: String? = null,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String? = null,
    @SerializedName("strCategoryThumb")
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