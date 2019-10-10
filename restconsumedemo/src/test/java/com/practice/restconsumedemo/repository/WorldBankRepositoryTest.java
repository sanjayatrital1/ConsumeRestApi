package com.practice.restconsumedemo.repository;

import com.practice.restconsumedemo.domain.Country;
import com.practice.restconsumedemo.worldbank.WorldBankApiClient;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RunWith(SpringRunner.class)
public class WorldBankRepositoryTest {

    static WorldBankRepository worldBankRepository = null;

    @BeforeClass
    public static void setup() {
        // Rest template
        RestTemplate restTemplate = new RestTemplate();
        WorldBankApiClient c = new WorldBankApiClient();
        c.setRestTemplate(restTemplate);
        c.setWorldBankApiBaseUrl("http://api.worldbank.org");

        worldBankRepository = c.getWorldBank();
    }

    @Test
    public void testCountryListIsNotEmpty() {
        List<Country> repoCountries = worldBankRepository.getCountryList();
        Assert.assertFalse(repoCountries.isEmpty());
    }

    @Test
    public void tesCountryAfghanistanExist() {
        for (Country c : worldBankRepository.getCountryList()) {
            if (c.getName().equalsIgnoreCase("Afghanistan")) {
                return;
            }
        }
        Assert.fail("Afghanistan country does not exist");
    }
}
