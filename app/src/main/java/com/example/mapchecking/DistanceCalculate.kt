package com.example.mapchecking

object DistanceCalculate {

    @Throws(java.lang.Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
        println("Distance-->" + distance(27.5328, 75.3668, 27.541758235265668, 75.37338847517458, "K") + " Kilometers\n")
        println("Distance-->" + distance(11.3341, 77.7126, 11.44616, 77.60755, "K") + " Kilometers\n")
        println("Distance-->" + distance(11.3441, 77.7017, 11.23147899, 77.84306268, "K") + " Kilometers\n")
        println("Distance-->" + distance(11.3643, 77.8094, 11.34972166666667, 77.77940666666667, "K") + " Kilometers\n")
        println("Distance-->" + distance(22.7698, 87.1559, 11.326098333333334, 77.73214166666666, "K") + " Kilometers\n")
        println("Distance-->" + distance(11.1923, 77.8462, 11.231479, 77.8430627, "K") + " Kilometers\n")
        println("Distance-->" + distance(27.7047, 76.1898, 27.65744296, 76.06381503, "K") + " Kilometers\n")
        println("Distance-->" + distance(27.4311, 75.5912, 27.3576817, 75.55494902, "K") + " Kilometers\n")
        println("Distance-->" + distance(27.6328, 76.1194, 27.94461666666667, 76.767405, "K") + " Kilometers\n")
        println("Distance-->" + distance(27.7151, 76.461, 27.71652166666667, 76.49047333333333, "K") + " Kilometers\n")
    }

    private fun distance(lat1: Double, lon1: Double, lat2: Double, lon2: Double, unit: String): Double {
        if (lat1 == lat2 && lon1 == lon2) {
            return 0.0
        } else {
            val theta = lon1 - lon2
            var dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) *
                    Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta))
            dist = Math.acos(dist)
            dist = Math.toDegrees(dist)
            dist *= 60.0 * 1.1515
            if (unit === "K") {
                dist *= 1.609344
            } else if (unit === "N") {
                dist *= 0.8684
            }
            return dist
        }
    }
}
