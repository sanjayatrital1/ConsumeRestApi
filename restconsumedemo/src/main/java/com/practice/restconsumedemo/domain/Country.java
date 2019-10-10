package com.practice.restconsumedemo.domain;

import java.util.Objects;

public class Country {

    private String id;

    private String iso2Code;

    private String name;

    private Region region;

    private Region incomeLevel;

    private Region lendingType;

    private Region adminRegion;

    private String capitalCity;

    private String longitude;

    private String latitude;

    public Country() {
        //
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIso2Code() {
        return iso2Code;
    }

    public void setIso2Code(String iso2Code) {
        this.iso2Code = iso2Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Region getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(Region incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public Region getLendingType() {
        return lendingType;
    }

    public void setLendingType(Region lendingType) {
        this.lendingType = lendingType;
    }

    public Region getAdminRegion() {
        return adminRegion;
    }

    public void setAdminRegion(Region adminRegion) {
        this.adminRegion = adminRegion;
    }

    public String getCapitalCity() {
        return capitalCity;
    }

    public void setCapitalCity(String capitalCity) {
        this.capitalCity = capitalCity;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(id, country.id) &&
                Objects.equals(iso2Code, country.iso2Code) &&
                Objects.equals(name, country.name) &&
                Objects.equals(region, country.region) &&
                Objects.equals(incomeLevel, country.incomeLevel) &&
                Objects.equals(lendingType, country.lendingType) &&
                Objects.equals(adminRegion, country.adminRegion) &&
                Objects.equals(capitalCity, country.capitalCity) &&
                Objects.equals(longitude, country.longitude) &&
                Objects.equals(latitude, country.latitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, iso2Code, name, region, incomeLevel, lendingType, adminRegion, capitalCity, longitude, latitude);
    }

    @Override
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", iso2Code='" + iso2Code + '\'' +
                ", name='" + name + '\'' +
                ", region=" + region +
                ", incomeLevel=" + incomeLevel +
                ", lendingType=" + lendingType +
                ", adminRegion=" + adminRegion +
                ", capitalCity='" + capitalCity + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
