package com.practice.restconsumedemo.worldbank;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.practice.restconsumedemo.domain.Country;
import com.practice.restconsumedemo.domain.Pages;
import com.practice.restconsumedemo.repository.WorldBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;

/**
 * To consume third party rest api
 */

@Service
public class WorldBankApiClient {
    @Value("${worldbank.api.baseurl}") /* To get value from application.properties file*/
    private String worldBankApiBaseUrl;
    @Autowired
    private RestTemplate restTemplate;

    public String getWorldBankApiBaseUrl() {
        return worldBankApiBaseUrl;
    }

    public void setWorldBankApiBaseUrl(String worldBankApiBaseUrl) {
        this.worldBankApiBaseUrl = worldBankApiBaseUrl;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * To fetch data from world bank API in json format
     * @return parse data from worldbankapi json to json class
     */
    public WorldBankRepository getWorldBank() {

        String api = worldBankApiBaseUrl + "/v2/country?format=json";

        URI uri = null;

        try {
            uri = new URI(api);
        } catch (URISyntaxException e) {
            throw new RuntimeException("error creating worldbank API", e);
        }

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return parseJson(response.getBody());
    }

    /**
     * To parse the data from worldBankAPI json response to JSON
     * @param json
     * @return
     */
    private WorldBankRepository parseJson(String json) {
        WorldBankRepository resp = new WorldBankRepository();

        Gson gson = new Gson();
        com.google.gson.JsonParser jsonParser = new JsonParser();
        JsonElement jsonTree = jsonParser.parse(json);

        if (jsonTree.isJsonArray()) {
            JsonArray arr = jsonTree.getAsJsonArray();

            // pages
            JsonElement e0 = arr.get(0);    // pages
            if (e0.isJsonObject()) {
                Pages page = gson.fromJson(e0.toString(), Pages.class);
                resp.setPages(page);
            }

            // countries
            JsonElement e1 = arr.get(1);
            if (e1.isJsonArray()) {
                JsonArray arr1 = e1.getAsJsonArray();
                Iterator<JsonElement> it = arr1.iterator();
                while (it.hasNext()) {
                    JsonElement e = it.next();
                    Country c = gson.fromJson(e.toString(), Country.class);
                    resp.addCountry(c);
                }
            }
        }
        return resp;
    }
}
