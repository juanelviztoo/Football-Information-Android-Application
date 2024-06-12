package com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.dashboard

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Club(
    val name: String,
    val desc: String,
    val img: Int,
    val league: String,
    val websiteUrl: String
) : Parcelable