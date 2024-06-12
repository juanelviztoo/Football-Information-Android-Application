package com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.dashboard

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.l0122054.elviztojuan.thewonderfulworldoffootball.R

class DetailClubFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_detail_club, container, false)

        // Mendapatkan data klub dari Bundle
        val club = arguments?.getParcelable<Club>("club_data")

        // Menampilkan detail klub
        val clubNameTextView: TextView = rootView.findViewById(R.id.tvDetailClubName)
        val clubDescTextView: TextView = rootView.findViewById(R.id.tvDetailClubDesc)
        val clubImageView: ImageView = rootView.findViewById(R.id.imgDetailClub)

        club?.let {
            clubNameTextView.text = it.name
            clubDescTextView.text = it.desc
            clubImageView.setImageResource(it.img)
        }

        // Mengatur aksi klik tombol
        val btnVisitWebsite: Button = rootView.findViewById(R.id.btnVisitWebsite)
        btnVisitWebsite.setOnClickListener {
            club?.let { openWebsite(it.websiteUrl) }
        }

        return rootView
    }

    // Fungsi untuk membuka URL
    private fun openWebsite(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}