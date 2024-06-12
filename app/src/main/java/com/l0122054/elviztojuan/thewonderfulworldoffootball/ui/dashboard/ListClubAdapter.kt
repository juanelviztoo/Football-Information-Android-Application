package com.l0122054.elviztojuan.thewonderfulworldoffootball.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.l0122054.elviztojuan.thewonderfulworldoffootball.R

class ListClubAdapter(private val listClub: ArrayList<Club>) : RecyclerView.Adapter<ListClubAdapter.ListViewHolder>() {

    interface OnItemClickCallback {
        fun onItemClicked(data: Club)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val llLeague: LinearLayout = itemView.findViewById(R.id.ll_league)
        val tvLeague: TextView = itemView.findViewById(R.id.tv_league)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_club, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listClub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, desc, img, league) = listClub[position]
        holder.imgPhoto.setImageResource(img)
        holder.tvName.text = name
        holder.tvDescription.text = desc

        // Tampilkan sub-judul liga sekali setiap 4 klub
        if (position % 4 == 0) {
            holder.llLeague.visibility = View.VISIBLE
            holder.tvLeague.text = league
        } else {
            holder.llLeague.visibility = View.GONE
        }

        // Mengatur onClickListener untuk membuka DetailClubFragment
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listClub[position])
        }
    }
}