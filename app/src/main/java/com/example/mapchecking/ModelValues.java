package com.example.mapchecking;

public class ModelValues {
    Double gpsLatitude;
    Double gpsLongitude;
    String isFromMap;
    String date;
    String farmerCode;
    String userNmae;
    String address;
    String city;
    String state;
    String country;
    String postalCode;
    Double googleAPIlatitude;
    Double googleAPIlongitude;

    public ModelValues(Double gpsLatitude, Double gpsLongitude, String isFromMap, String date, String farmerCode, String userNmae, String address, String city, String state, String country, String postalCode, Double googleAPIlatitude, Double googleAPIlongitude) {
        this.gpsLatitude = gpsLatitude;
        this.gpsLongitude = gpsLongitude;
        this.isFromMap = isFromMap;
        this.date = date;
        this.farmerCode = farmerCode;
        this.userNmae = userNmae;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.googleAPIlatitude = googleAPIlatitude;
        this.googleAPIlongitude = googleAPIlongitude;
    }

    public Double getGpsLatitude() {
        return gpsLatitude;
    }

    public void setGpsLatitude(Double gpsLatitude) {
        this.gpsLatitude = gpsLatitude;
    }

    public Double getGpsLongitude() {
        return gpsLongitude;
    }

    public void setGpsLongitude(Double gpsLongitude) {
        this.gpsLongitude = gpsLongitude;
    }

    public String getIsFromMap() {
        return isFromMap;
    }

    public void setIsFromMap(String isFromMap) {
        this.isFromMap = isFromMap;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFarmerCode() {
        return farmerCode;
    }

    public void setFarmerCode(String farmerCode) {
        this.farmerCode = farmerCode;
    }

    public String getUserNmae() {
        return userNmae;
    }

    public void setUserNmae(String userNmae) {
        this.userNmae = userNmae;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Double getGoogleAPIlatitude() {
        return googleAPIlatitude;
    }

    public void setGoogleAPIlatitude(Double googleAPIlatitude) {
        this.googleAPIlatitude = googleAPIlatitude;
    }

    public Double getGoogleAPIlongitude() {
        return googleAPIlongitude;
    }

    public void setGoogleAPIlongitude(Double googleAPIlongitude) {
        this.googleAPIlongitude = googleAPIlongitude;
    }
}
