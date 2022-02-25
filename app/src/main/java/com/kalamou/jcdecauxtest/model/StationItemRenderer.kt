package com.kalamou.jcdecauxtest.model

import android.content.Context
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer
import com.kalamou.jcdecauxtest.R
import com.kalamou.jcdecauxtest.place.Place
import com.kalamou.jcdecauxtest.utils.BitmapHelper

class StationItemRendererprivate(val context: Context,
                                 map: GoogleMap,
                                 clusterManager: ClusterManager<StationsItem>
) : DefaultClusterRenderer<StationsItem>(context, map, clusterManager) {

    /**
     * The icon to use for each cluster item
     */
    private val bicycleIcon: BitmapDescriptor by lazy {
        val color = ContextCompat.getColor(
            context,
            R.color.colorPrimary
        )
        BitmapHelper.vectorToBitmap(
            context,
            R.drawable.ic_directions_bike_black_24dp,
            color
        )
    }

    /**
     * Method called before the cluster item (the marker) is rendered.
     * This is where marker options should be set.
     */
    override fun onBeforeClusterItemRendered(
        item: StationsItem,
        markerOptions: MarkerOptions
    ) {
        markerOptions.title(item.name)
            .position(item.position.latitude as LatLng)
            .icon(bicycleIcon)
    }

    /**
     * Method called right after the cluster item (the marker) is rendered.
     * This is where properties for the Marker object should be set.
     */
    override fun onClusterItemRendered(clusterItem: StationsItem, marker: Marker) {
        marker.tag = clusterItem
    }
}