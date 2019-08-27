package com.example.mapchecking

import android.Manifest
import android.app.Service
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.IBinder
import android.provider.Settings

import androidx.core.app.ActivityCompat
import androidx.appcompat.app.AlertDialog

import android.widget.Toast

import com.google.android.gms.location.LocationRequest


class LocationTrack : Service, LocationListener {
    private val mContext: Context?
    var checkGPS = false
    var checkNetwork = false
    var canGetLocation = false
    var loc: Location? = null
    private var latitude: Double? = 0.toDouble()
    private var longitude: Double? = 0.toDouble()
    var locationManager: LocationManager? = null

    private val location: Location?
        get() {
            try {
                locationManager = mContext!!
                        .getSystemService(Context.LOCATION_SERVICE) as LocationManager
                checkGPS = locationManager!!
                        .isProviderEnabled(LocationManager.GPS_PROVIDER)
                checkNetwork = locationManager!!
                        .isProviderEnabled(LocationManager.NETWORK_PROVIDER)
                if (!checkGPS && !checkNetwork) {
                    Toast.makeText(mContext, "No Service Provider is available", Toast.LENGTH_SHORT).show()
                } else {
                    this.canGetLocation = true

                    if (checkGPS) {
                        if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        }

                        locationManager!!.requestLocationUpdates(
                                LocationManager.GPS_PROVIDER,
                                MIN_TIME_BW_UPDATES,
                                MIN_DISTANCE_CHANGE_FOR_UPDATES.toFloat(), this)

                        if (locationManager != null) {
                            loc = locationManager!!
                                    .getLastKnownLocation(LocationManager.GPS_PROVIDER)
                            if (loc != null) {
                                latitude = loc!!.latitude
                                longitude = loc!!.longitude
                            }
                        }
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return loc
        }

    constructor(mContext: Context) {
        this.mContext = mContext
        location
    }

    constructor() {
        mContext = null
    }

    fun getLongitude(): Double {
        if (loc != null) {
            longitude = loc!!.longitude
        }
        return longitude!!
    }

    fun getLatitude(): Double {
        if (loc != null) {
            latitude = loc!!.latitude
        }
        return latitude!!
    }

    fun canGetLocation(): Boolean {

        try {
            locationManager = mContext!!
                    .getSystemService(Context.LOCATION_SERVICE) as LocationManager
            checkGPS = locationManager!!
                    .isProviderEnabled(LocationManager.GPS_PROVIDER)
            checkNetwork = locationManager!!
                    .isProviderEnabled(LocationManager.NETWORK_PROVIDER)
            if (!checkGPS && !checkNetwork) {
                Toast.makeText(mContext, "No Service Provider is available", Toast.LENGTH_SHORT).show()
            } else {
                this.canGetLocation = true

                if (checkGPS) {
                    return true
                }
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }


    fun showSettingsAlert() {
        val alertDialog = AlertDialog.Builder(mContext!!)
        alertDialog.setTitle("GPS is not Enabled!")
        alertDialog.setMessage("Do you want to turn on GPS?")
        alertDialog.setPositiveButton("Yes") { dialog, which ->
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            mContext.startActivity(intent)
        }

        alertDialog.setNegativeButton("No") { dialog, which -> dialog.cancel() }


        alertDialog.show()
    }

    fun stopListener() {
        if (locationManager != null) {

            if (ActivityCompat.checkSelfPermission(mContext!!, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return
            }
            locationManager!!.removeUpdates(this@LocationTrack)
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onLocationChanged(location: Location) {

    }

    override fun onStatusChanged(s: String, i: Int, bundle: Bundle) {

    }

    override fun onProviderEnabled(s: String) {

    }

    override fun onProviderDisabled(s: String) {

    }

    companion object {
        private val MIN_DISTANCE_CHANGE_FOR_UPDATES: Long = 1
        private val MIN_TIME_BW_UPDATES = (1000 * 60 * 1).toLong()
    }
}
