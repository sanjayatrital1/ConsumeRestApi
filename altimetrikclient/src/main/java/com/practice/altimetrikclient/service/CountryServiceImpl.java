package com.practice.altimetrikclient.service;

import com.practice.altimetrikclient.domain.Country;
import com.sun.javafx.fxml.builder.URLBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private RestTemplate restTemplate;

    private String countryUrl = "http://localhost:8080/v1/country?countryCode=";

    UriComponentsBuilder ub = UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
            .path("/v1/country");

    @Override
    public List<Country> getAllList(String countryCode,String region, String incomeLevel, String lendingType) {
        ub.queryParam("countryCode", countryCode);
        ub.queryParam("region",region);
        ub.queryParam("incomeLevel",incomeLevel);
        ub.queryParam("lendingType",lendingType);
        ub.build();

        String uriString = ub.toUriString();

//        URI u1 = null;
//        try {
//            u1 = new URI(countryUrl + CountryCode);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//        ResponseEntity<String> r1 = restTemplate.getForEntity(u1, String.class);
//        System.out.println(r1);

        System.out.println("Calling " + uriString);
        ResponseEntity<List<Country>> response =
                restTemplate.exchange(uriString, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Country>>() {
                        });
        System.out.println(response.getStatusCodeValue());
        System.out.println(response.getBody());
        return response.getBody();
    }
}
