package com.practice.restconsumedemo.repository;

import com.practice.restconsumedemo.domain.Country;
import com.practice.restconsumedemo.domain.Pages;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * To store the Json data fetch from worldBankApi class
 */

@Repository
public class WorldBankRepository {

    private Pages pages;

    private List<Country> countryList= new ArrayList<>();

    public WorldBankRepository(){
        //
    }

    public Pages getPages() {
        return pages;
    }

    public void setPages(Pages pages) {
        this.pages = pages;
    }

    public List<Country> getCountryList() {
        return Collections.unmodifiableList(countryList);
    }

    public void addCountry(Country country) {
        this.countryList.add(country);
    }

    public void addCountryList(List<Country> countryList) {
        this.countryList.clear();
        this.countryList.addAll(countryList);
    }

    @Override
    public String toString() {
        return "WorldBankCountryList{" +
                "pages=" + pages +
                ", countryList=" + countryList +
                '}';
    }
}
