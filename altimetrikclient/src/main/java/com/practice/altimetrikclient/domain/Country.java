package com.practice.altimetrikclient.domain;

import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlElement
public class Country {

    private String country;
    private String countryCode;
    private String matchRegion;
    private String incomeLevel;
    private String lendingType;
    private String capital;

    public Country(){
        //
    }

    public String getCapital() {
        return capital;
    }

    public String getCountry() {
        return country;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getMatchRegion() {
        return matchRegion;
    }

    public void setMatchRegion(String matchRegion) {
        this.matchRegion = matchRegion;
    }

    public String getIncomeLevel() {
        return incomeLevel;
    }

    public void setIncomeLevel(String incomeLevel) {
        this.incomeLevel = incomeLevel;
    }

    public String getLendingType() {
        return lendingType;
    }

    public void setLendingType(String lendingType) {
        this.lendingType = lendingType;
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", matchRegion='" + matchRegion + '\'' +
                ", incomeLevel='" + incomeLevel + '\'' +
                ", lendingType='" + lendingType + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
