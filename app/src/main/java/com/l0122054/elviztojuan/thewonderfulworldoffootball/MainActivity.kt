package com.l0122054.elviztojuan.thewonderfulworldoffootball

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.l0122054.elviztojuan.thewonderfulworldoffootball.databinding.ActivityMainBinding
import com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.profile.Profile
import com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.profile.ProfileViewModel

class MainActivity : AppCompatActivity() {

    private val profileViewModel: ProfileViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_profile
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Mendapatkan data profil
        val profile = Profile(
            fullName = getString(R.string.fullname_placeholder),
            nim = getString(R.string.nim_placeholder),
            majorBatch = getString(R.string.major_year_placeholder),
            faculty = getString(R.string.faculty_placeholder),
            university = getString(R.string.university_placeholder),
            email = getString(R.string.email_placeholder)
        )

        // Menyimpan data profil ke dalam ProfileViewModel
        profileViewModel.setProfile(profile)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}