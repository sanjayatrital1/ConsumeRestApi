package com.practice.restconsumedemo.controller;

import com.practice.restconsumedemo.domain.CountryView;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorldBankController {

    ResponseEntity<List<CountryView>> searchCountry(String countryCode, String region, String incomeLevel, String lendingType);
}
