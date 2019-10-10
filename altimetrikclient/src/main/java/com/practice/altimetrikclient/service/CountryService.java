package com.practice.altimetrikclient.service;

import com.practice.altimetrikclient.domain.Country;

import java.util.List;

public interface CountryService {
    public List<Country>getAllList(String countryCode,String region, String incomeLevel, String lendingType);
}
