package com.practice.restconsumedemo;

import com.practice.restconsumedemo.repository.WorldBankRepository;
import com.practice.restconsumedemo.worldbank.WorldBankApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ApplicationInitializer {

    @Autowired
    private WorldBankApiClient worldBankApiClient;

    @Autowired
    private WorldBankRepository worldBankRepository;

    public void setWorldBankApiClient(WorldBankApiClient worldBankApiClient) {
        this.worldBankApiClient = worldBankApiClient;
    }

    public void setWorldBankRepository(WorldBankRepository worldBankRepository) {
        this.worldBankRepository = worldBankRepository;
    }

    /**
     * Call the worldBankApiclient during startup and store the data in WorldBankRepository
     */

    @PostConstruct
    public void applicationInitializer() {
        WorldBankRepository wbcList = worldBankApiClient.getWorldBank();
        worldBankRepository.addCountryList(wbcList.getCountryList());
    }

}
