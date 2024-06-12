package com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {
    private val _profileData = MutableLiveData<Profile>()
    val profileData: LiveData<Profile>
        get() = _profileData

    fun setProfile(profile: Profile) {
        _profileData.value = profile
    }
}