package com.practice.com.altrimetrikdemo.bean;

import com.practice.com.altrimetrikdemo.worldbank.Country;
import com.sun.xml.txw2.annotation.XmlElement;

@XmlElement
public class CountryView {

    private String country;

    private String capital;

    public CountryView() {
        //
    }

    public static CountryView from(Country c) {
        CountryView v = new CountryView();
        v.setCountry(c.getName());
        v.setCapital(c.getCapitalCity());
        return v;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
}
