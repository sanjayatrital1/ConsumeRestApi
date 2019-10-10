package com.practice.com.altrimetrikdemo.service;

import com.practice.com.altrimetrikdemo.repository.PageRepository;
import com.practice.com.altrimetrikdemo.worldbank.Country;
import com.practice.com.altrimetrikdemo.worldbank.WorldBankApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CountryService {

    @Autowired
    private WorldBankApiClient client;
    @Autowired
    private PageRepository pageRepository;

    public void setClient(WorldBankApiClient client) {
        this.client = client;
    }

    public List<Country> searchCountires(String countryCode, String region, String incomeLevel, String lendingType) {
        System.out.println(client.getCountryList().getCountry());
        return pageRepository.searchCountry(countryCode,region,incomeLevel,lendingType);
//        return client.getCountryList().getCountry();
    }
}
