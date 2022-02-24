package com.kalamou.jcdecauxtest.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import com.kalamou.jcdecauxtest.databinding.FragmentOverviewBinding
import com.kalamou.jcdecauxtest.model.StationsItem
import com.kalamou.jcdecauxtest.utils.GpsTracker


class OverViewFragment : Fragment() {

    private lateinit var stationsItem: StationsItem

    private val viewModel: OverviewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentOverviewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.rv.adapter = StationGridAdapter()

        return binding.root

    }

    override fun onResume() {
        super.onResume()
        getLocation()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        try {
            if (ContextCompat.checkSelfPermission(
                    getApplicationContext(),
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                ActivityCompat.requestPermissions(
                    requireActivity(),
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    101
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun getLocation() {
        val gpsTracker = GpsTracker(requireContext())
        if (gpsTracker.canGetLocation()) {
            val latitude = gpsTracker.latitude
            val longitude = gpsTracker.longitude
            Log.d("TAG", "getLocation: $latitude + $longitude")
            viewModel.getStations(latitude, longitude)
        } else {
            gpsTracker.showSettingsAlert()
        }
    }
}