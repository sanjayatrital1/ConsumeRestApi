package com.practice.com.altrimetrikdemo.worldbank;

import com.sun.xml.internal.txw2.annotation.XmlElement;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlElement
@XmlAccessorType(XmlAccessType.NONE)
@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cid;

    private String id;

    private String iso2Code;

    @javax.xml.bind.annotation.XmlElement
    private String name;


    @OneToOne(cascade = CascadeType.ALL)
    private Region region;


    @OneToOne(cascade = CascadeType.ALL)
    private Region adminregion;


    @OneToOne(cascade = CascadeType.ALL)
    private Region incomeLevel;


    @OneToOne(cascade = CascadeType.ALL)
    private Region lendingType;

    @javax.xml.bind.annotation.XmlElement
    private String capitalCity;

    private String longitude;

    private String latitude;

    public Country() {
        //
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
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

    public Region getAdminregion() {
        return adminregion;
    }

    public void setAdminregion(Region adminregion) {
        this.adminregion = adminregion;
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
    public String toString() {
        return "Country{" +
                "id='" + id + '\'' +
                ", iso2Code='" + iso2Code + '\'' +
                ", name='" + name + '\'' +
                ", region=" + region +
                ", adminRegion=" + adminregion +
                ", incomeLevel=" + incomeLevel +
                ", lendingType=" + lendingType +
                ", capitalCity='" + capitalCity + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }
}
