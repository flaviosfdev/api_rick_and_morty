package com.flaviosf.rickandmorty.domain.model.character

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Character(
    @SerializedName("name")
    val name: String?,
    @SerializedName("status")
    val status: String?,
    @SerializedName("image")
    val photo: String?,
    @SerializedName("gender")
    val gender: String?
) : Parcelable