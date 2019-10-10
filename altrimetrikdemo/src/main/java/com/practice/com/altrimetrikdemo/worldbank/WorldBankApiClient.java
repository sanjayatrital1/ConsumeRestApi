package com.practice.com.altrimetrikdemo.worldbank;

import com.google.gson.*;
import com.practice.com.altrimetrikdemo.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

@Service
@Transactional
public class WorldBankApiClient {

    @Value("${worldbank.api.baseurl}")
    private String worldBankApiBaseUrl;

    public void setWorldBankApiBaseUrl(String worldBankApiBaseUrl) {
        this.worldBankApiBaseUrl = worldBankApiBaseUrl;
    }

    private WorldBankCountryList countryList;

    public WorldBankCountryList getCountryList() {
        return countryList;
    }

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private PageRepository pageRepository;


    @PostConstruct
    public void getWorldBankCountries() {
        String api = worldBankApiBaseUrl + "/v2/country?format=json";

        URI uri = null;
        try {
            uri = new URI(api);
        } catch (URISyntaxException e) {
            throw new RuntimeException("error creating worldbank API", e);
        }

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        countryList = parseJson(response.getBody());
        // loop over country and save via hibernate

        for (Country c : countryList.getCountry()) {
                pageRepository.save(c);
        }
        pageRepository.flush();




    }

    private WorldBankCountryList parseJson(String json) {
        WorldBankCountryList resp = new WorldBankCountryList();

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonElement jsonTree = jsonParser.parse(json);

        if (jsonTree.isJsonArray()) {
            JsonArray arr = jsonTree.getAsJsonArray();

            // pages
            JsonElement e0 = arr.get(0);    // pages
            if (e0.isJsonObject()) {
                Pages page = gson.fromJson(e0.toString(), Pages.class);
                resp.setPage(page);
            }

            // countries
            JsonElement e1 = arr.get(1);
            if (e1.isJsonArray()) {
                JsonArray arr1 = e1.getAsJsonArray();
                Iterator<JsonElement> it = arr1.iterator();
                while (it.hasNext()) {
                    JsonElement e = it.next();
                    Country c = gson.fromJson(e.toString(), Country.class);
                    resp.getCountry().add(c);
                }
            }
        }
        return resp;
    }
}
