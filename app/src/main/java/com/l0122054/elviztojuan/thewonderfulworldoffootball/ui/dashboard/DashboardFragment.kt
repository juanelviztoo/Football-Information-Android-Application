package com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.l0122054.elviztojuan.thewonderfulworldoffootball.R

class DashboardFragment : Fragment() {

    private lateinit var rvClub: RecyclerView
    private val list = ArrayList<Club>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)

        rvClub = root.findViewById(R.id.rv_football_club)
        rvClub.setHasFixedSize(true)

        list.addAll(getListClubs())
        showRecyclerList()

        return root
    }

    private fun getListClubs(): ArrayList<Club> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataImg = resources.obtainTypedArray(R.array.data_img)
        val leagues = resources.getStringArray(R.array.leagues)
        val websites = resources.getStringArray(R.array.club_websites)

        val listClub = ArrayList<Club>()

        for (i in dataName.indices) {
            val websiteUrl = if (i < websites.size) websites[i] else ""
            val club = Club(dataName[i], dataDesc[i], dataImg.getResourceId(i, -1), leagues[i / 4], websiteUrl)
            listClub.add(club)
        }
        return listClub
    }

    private fun showRecyclerList() {
        rvClub.layoutManager = LinearLayoutManager(requireContext())
        val listClubAdapter = ListClubAdapter(list)
        rvClub.adapter = listClubAdapter

        listClubAdapter.setOnItemClickCallback(object : ListClubAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Club) {
                val bundle = Bundle().apply {
                    putParcelable("club_data", data)
                }
                findNavController().navigate(R.id.action_dashboardFragment_to_detailClubFragment, bundle)
            }
        })
    }
}