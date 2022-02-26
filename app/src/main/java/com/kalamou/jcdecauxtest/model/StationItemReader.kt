package com.kalamou.jcdecauxtest.model

import android.content.Context
import com.google.android.gms.maps.GoogleMap
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.ClusterRenderer
import com.kalamou.jcdecauxtest.R
import java.io.InputStream
import java.io.InputStreamReader

class StationItemReader(
    private val context: Context
) : ClusterRenderer<StationsItem> {

    private val gson = Gson()

    private val inputStream: InputStream
        get() = context.resources.openRawResource(R.raw.jcdecauxbike)

    fun read(): List<StationsItem> {
        val itemType = object : TypeToken<List<StationsItemresponse>>() {}.type
        val reader = InputStreamReader(inputStream)
        return gson.fromJson<List<StationsItemresponse>>(reader, itemType).map {
            it.toStationItem()
        }
    }

    override fun onClustersChanged(clusters: MutableSet<out Cluster<StationsItem>>?) {
        //TODO("Not yet implemented")
    }

    override fun setOnClusterClickListener(listener: ClusterManager.OnClusterClickListener<StationsItem>?) {
        //TODO("Not yet implemented")
    }

    override fun setOnClusterInfoWindowClickListener(listener: ClusterManager.OnClusterInfoWindowClickListener<StationsItem>?) {
        //TODO("Not yet implemented")
    }

    override fun setOnClusterInfoWindowLongClickListener(listener: ClusterManager.OnClusterInfoWindowLongClickListener<StationsItem>?) {
        //TODO("Not yet implemented")
    }

    override fun setOnClusterItemClickListener(listener: ClusterManager.OnClusterItemClickListener<StationsItem>?) {
        //TODO("Not yet implemented")
    }

    override fun setOnClusterItemInfoWindowClickListener(listener: ClusterManager.OnClusterItemInfoWindowClickListener<StationsItem>?) {
        //TODO("Not yet implemented")
    }

    override fun setOnClusterItemInfoWindowLongClickListener(listener: ClusterManager.OnClusterItemInfoWindowLongClickListener<StationsItem>?) {
        //TODO("Not yet implemented")
    }

    override fun setAnimation(animate: Boolean) {
        //TODO("Not yet implemented")
    }

    override fun onAdd() {
       // TODO("Not yet implemented")
    }

    override fun onRemove() {
        //TODO("Not yet implemented")
    }
}