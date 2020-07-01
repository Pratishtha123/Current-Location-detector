package com.paru.location

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MainActivity : AppCompatActivity() {

    lateinit var mapFragment:SupportMapFragment
    lateinit var googleMap:GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
            googleMap.isMyLocationEnabled=true

            googleMap.setOnMyLocationChangeListener(OnMyLocationChangeListener { location ->
                val center = CameraUpdateFactory.newLatLng(
                    LatLng(
                        location.latitude,
                        location.longitude
                    )
                )
                val zoom = CameraUpdateFactory.zoomTo(11f)
               googleMap.moveCamera(center)
                googleMap.animateCamera(zoom)
                val currentLocation=LatLng(location.latitude,location.longitude)
                googleMap.addMarker(MarkerOptions().position(currentLocation))
            })

        })
    }
}
