package com.nguyen.imagesearch3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Photo(val description: String?, val id: String, val urls: Urls, val user: User): Parcelable