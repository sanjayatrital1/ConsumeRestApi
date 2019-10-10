package com.practice.com.altrimetrikdemo.controller;

import com.practice.com.altrimetrikdemo.bean.CountryView;
import com.practice.com.altrimetrikdemo.worldbank.Country;

import java.util.List;

public interface CountryRestController {

    List<CountryView> searchCountry(String countryCode, String region, String incomeLevel, String lendingType);
}
