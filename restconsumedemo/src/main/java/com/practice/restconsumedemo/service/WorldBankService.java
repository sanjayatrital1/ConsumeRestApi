package com.practice.restconsumedemo.service;

import com.practice.restconsumedemo.repository.WorldBankRepository;
import com.practice.restconsumedemo.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * To perform business logic and get data from repository and return to controller class
 */

@Service
public class WorldBankService {

    @Autowired
    private WorldBankRepository worldBankRepository;

    public void setWorldBankRepository(WorldBankRepository worldBankRepository) {
        this.worldBankRepository = worldBankRepository;
    }

    public Collection<Country> searchCountires(String countryCode, String region, String incomeLevel, String lendingType) {
        System.out.println(worldBankRepository.getCountryList());
        System.out.println("============================");
        System.out.println("CountryCode="+countryCode+"  region ="+region+" Income Level ="+incomeLevel+" Lending Type = "+lendingType);
        System.out.println("++++++++++++++++++++++++++++++");
//        return pageRepository.searchCountry(countryCode,region,incomeLevel,lendingType);

        Set<Country> result = new HashSet<>();

        // search criteria
        for (Country c : worldBankRepository.getCountryList()) {
            // Add if country code is found
            System.out.println("checking " + countryCode + " with - " + c.getIso2Code());
            if (c.getIso2Code() !=null && c.getIso2Code().equalsIgnoreCase(countryCode)) {
                result.add(c);
            }

            // Check for region
            if (region != null && !region.trim().isEmpty()) {
                if (c.getRegion() != null && c.getRegion().getValue().equalsIgnoreCase(region)) {
                    result.add(c);
                }
            }

            //check for incomeLevel
            if(incomeLevel != null && !incomeLevel.trim().isEmpty()){
                System.out.println("Checking Income =="+incomeLevel +"with-- "+c.getIncomeLevel());
                if(c.getIncomeLevel() != null && c.getIncomeLevel().getValue().equalsIgnoreCase(incomeLevel)){
                    result.add(c);
                }
            }

            //check for lending Type
            if(lendingType != null && !lendingType.trim().isEmpty()){
                if (c.getLendingType() != null && c.getLendingType().getValue().equalsIgnoreCase(lendingType)) {
                    result.add(c);
                }
            }
        }

        return result;
    }
}
