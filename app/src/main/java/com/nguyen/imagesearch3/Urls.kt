package com.nguyen.imagesearch3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Urls(val full: String, val raw: String, val regular: String, val small: String, val thumb: String): Parcelable