package com.senac.projetoclima.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@Entity
public class Results implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int temp;
    private String date;
    private String time;
    private String condition_code;
    private String description;
    private String currently;
    private String cid;
    private String city;
    private String img_id;
    private int humidity;
    private String wind_speedy;
    private String sunrise;
    private String sunset;
    private String condition_slug;
    private String city_name;
    private List<Forecast> forecast;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCondition_code() {
        return condition_code;
    }

    public void setCondition_code(String condition_code) {
        this.condition_code = condition_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrently() {
        return currently;
    }

    public void setCurrently(String currently) {
        this.currently = currently;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getImg_id() {
        return img_id;
    }

    public void setImg_id(String img_id) {
        this.img_id = img_id;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public String getWind_speedy() {
        return wind_speedy;
    }

    public void setWind_speedy(String wind_speedy) {
        this.wind_speedy = wind_speedy;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getCondition_slug() {
        return condition_slug;
    }

    public void setCondition_slug(String condition_slug) {
        this.condition_slug = condition_slug;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
       this.forecast = forecast;
    }
}
