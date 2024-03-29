package com.kalamou.jcdecauxtest

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.google.android.gms.maps.model.Marker
import com.google.android.libraries.maps.GoogleMap
import com.kalamou.jcdecauxtest.place.Place

class MarkerInfoWindowAdapter(
    private val context: Context
) : com.google.android.gms.maps.GoogleMap.InfoWindowAdapter {


    override fun getInfoWindow(p0: Marker): View? {
        return null
    }

    override fun getInfoContents(p0: Marker): View? {
        // 1. Get tag
        val place = p0?.tag as? Place ?: return null

        // 2. Inflate view and set title, address, and rating
        val view = LayoutInflater.from(context).inflate(
            R.layout.marker_info_contents, null
        )
        view.findViewById<TextView>(
            R.id.text_view_title
        ).text = place.name
        view.findViewById<TextView>(
            R.id.text_view_address
        ).text = place.address
        view.findViewById<TextView>(
            R.id.text_view_rating
        ).text = "Rating: %.2f".format(place.rating)

        return view
    }
}