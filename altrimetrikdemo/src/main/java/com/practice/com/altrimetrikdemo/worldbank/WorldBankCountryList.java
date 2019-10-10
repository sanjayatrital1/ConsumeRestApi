package com.practice.com.altrimetrikdemo.worldbank;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class WorldBankCountryList {


//    @Transient
    private Pages page;

    private List<Country> country = new ArrayList<>();

    public WorldBankCountryList() {
        //
    }

    public Pages getPage() {
        return page;
    }

    public void setPage(Pages page) {
        this.page = page;
    }

    public List<Country> getCountry() {
        return country;
    }

    public void setCountry(List<Country> country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "WorldBankCountryResponse{" +
                "page=" + page +
                ", country=" + country +
                '}';
    }
}
