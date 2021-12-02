package com.example.citytrafficanalytics.model;

/**
 * @author Lucas Copque
 * @since 01/12/2021
 */

public class CityAnalytic {

    private Long id;
    private String city;
    private Integer vehicles;
    private Integer accidents;

    public CityAnalytic() {
    }

    public CityAnalytic(Long id, String city, Integer vehicles, Integer accidents) {
        this.id = id;
        this.city = city;
        this.vehicles = vehicles;
        this.accidents = accidents;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getVehicles() {
        return vehicles;
    }

    public void setVehicles(Integer vehicles) {
        this.vehicles = vehicles;
    }

    public Integer getAccidents() {
        return accidents;
    }

    public void setAccidents(Integer accidents) {
        this.accidents = accidents;
    }

    @Override
    public String toString() {
        return "CityAnalytic{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", vehicles=" + vehicles +
                ", accidents=" + accidents +
                '}';
    }
}