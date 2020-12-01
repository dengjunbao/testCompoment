package com.component.entity;

public class Position {
    private Double lng;
    private Double lat;
    private String prvePoint;
    private String newPoint;
    private String carNumber;
    private String degreeCelsius;


    public Position(){}
    public Position(String prvePoint, String newPoint, String carNumber, String degreeCelsius,Double lng,Double lat) {
        this.lng = lng;
        this.lat = lat;
        this.prvePoint = prvePoint;
        this.newPoint = newPoint;
        this.carNumber = carNumber;
        this.degreeCelsius = degreeCelsius;
    }

    @Override
    public String toString() {
        return "Position{" +
                "lng=" + lng +
                ", lat=" + lat +
                ", prvePoint=" + prvePoint +
                ", newPoint=" + newPoint +
                ", carNumber=" + carNumber +
                ", degreeCelsius=" + degreeCelsius +
                '}';
    }

    public Double getlng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public String getPrvePoint() {
        return prvePoint;
    }

    public void setPrvePoint(String prvePoint) {
        this.prvePoint = prvePoint;
    }

    public String getNewPoint() {
        return newPoint;
    }

    public void setNewPoint(String newPoint) {
        this.newPoint = newPoint;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getDegreeCelsius() {
        return degreeCelsius;
    }

    public void setDegreeCelsius(String degreeCelsius) {
        this.degreeCelsius = degreeCelsius;
    }
}
