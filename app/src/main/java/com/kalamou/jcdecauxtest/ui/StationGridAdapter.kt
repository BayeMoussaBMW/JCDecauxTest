package com.kalamou.jcdecauxtest.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kalamou.jcdecauxtest.databinding.GridViewItemBinding
import com.kalamou.jcdecauxtest.model.StationsItem
import com.kalamou.jcdecauxtest.utils.visibleOrGone

class StationGridAdapter :
    ListAdapter<StationsItem, StationGridAdapter.StationsViewHolder>(DiffCallback) {

    var onItemClick: ((StationsItem) -> Unit)? = null
    var stations: List<StationsItem> = emptyList()

    inner class StationsViewHolder(
        private var binding: GridViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(stationsItem: StationsItem) {
            binding.tvLat.text = "Lat:" + stationsItem.position.latitude.toString()
            binding.tvLng.text = "Lng:" + stationsItem.position.longitude.toString()
            if (stationsItem.totalStands.availabilities.bikes != 0) {
                binding.tvBikes.text =
                    "total:" + stationsItem.totalStands.availabilities.bikes.toString()
            }

            binding.imvPin.setOnClickListener {
                launchMap()
            }

            binding.executePendingBindings()
        }

        private fun launchMap() {
            binding.imvPin.setOnClickListener {

            }
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(stations[adapterPosition])
                binding.imvPin.visibleOrGone(true)
            }
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<StationsItem>() {
        override fun areItemsTheSame(oldItem: StationsItem, newItem: StationsItem): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: StationsItem, newItem: StationsItem): Boolean {
            return oldItem.name == newItem.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StationsViewHolder {
        return StationsViewHolder(
            GridViewItemBinding.inflate(LayoutInflater.from(parent.context))
        )
    }

    override fun onBindViewHolder(holder: StationsViewHolder, position: Int) {
        val station = getItem(position)
        holder.bind(station)
    }

}