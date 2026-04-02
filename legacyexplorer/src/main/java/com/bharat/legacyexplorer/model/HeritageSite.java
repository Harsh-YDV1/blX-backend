package com.bharat.legacyexplorer.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
// Use the singular table to avoid duplicate tables (heritage_site vs heritage_sites)
@Table(name = "heritage_site")
public class HeritageSite extends BaseNamedEntity {
    @Column(length = 255)
    private String city;
    @Column(length = 255)
    private String category;
    @Column(name = "nearest_railway", length = 255)
    private String nearestRailway;
    @Column(name = "nearest_airport", length = 255)
    private String nearestAirport;
    @Column(name = "image_url", length = 1024)
    private String imageUrl;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getNearestRailway() { return nearestRailway; }
    public void setNearestRailway(String nearestRailway) { this.nearestRailway = nearestRailway; }

    public String getNearestAirport() { return nearestAirport; }
    public void setNearestAirport(String nearestAirport) { this.nearestAirport = nearestAirport; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }
}
