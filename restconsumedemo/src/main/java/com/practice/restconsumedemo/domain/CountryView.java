package com.practice.restconsumedemo.domain;

import java.util.Objects;

/**
 * To store Country Json data
 */
public class CountryView {

    private String countryName;

    private String capital;

    public static CountryView from(Country country){
        CountryView view = new CountryView();
        view.setCapital(country.getCapitalCity());
        view.setCountryName(country.getName());
        return view;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryView that = (CountryView) o;
        return Objects.equals(countryName, that.countryName) &&
                Objects.equals(capital, that.capital);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryName, capital);
    }

    @Override
    public String toString() {
        return "CountryView{" +
                "countryName='" + countryName + '\'' +
                ", capital='" + capital + '\'' +
                '}';
    }
}
