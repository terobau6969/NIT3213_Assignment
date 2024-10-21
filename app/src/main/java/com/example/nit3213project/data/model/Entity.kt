package com.example.nit3213project.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Entity(
    val title: String,
    val author: String,
    val genre: String,
    val publicationYear: Int,
    val description: String
) : Parcelable
