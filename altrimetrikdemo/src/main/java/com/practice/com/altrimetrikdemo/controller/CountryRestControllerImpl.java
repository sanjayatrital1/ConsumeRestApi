package com.practice.com.altrimetrikdemo.controller;

import com.practice.com.altrimetrikdemo.bean.CountryView;
import com.practice.com.altrimetrikdemo.bean.ErrorCode;
import com.practice.com.altrimetrikdemo.bean.ErrorResponse;
import com.practice.com.altrimetrikdemo.service.CountryService;
import com.practice.com.altrimetrikdemo.worldbank.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryRestControllerImpl implements CountryRestController {

    @Autowired
    private CountryService countryService;

    public void setCountryService(CountryService countryService) {
        this.countryService = countryService;
    }

    @Override
    @GetMapping(value = "/v1/country", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CountryView> searchCountry(
            @RequestParam("countryCode") String countryCode,
            @RequestParam(value = "region", required = false) String region,
            @RequestParam(value = "incomeLevel", required = false) String incomeLevel,
            @RequestParam(value = "lendingType", required = false) String lendingType) {

        // TODO search for country
        List<Country> countryList= countryService.searchCountires(countryCode, region, incomeLevel, lendingType);

        if (countryList == null || countryList.isEmpty()) {
            throw new RestControllerException(ErrorCode.COUNTRY_NOT_FOUND, 404);
        }

        List<CountryView> cView = new ArrayList<>();
        if (countryList != null && !countryList.isEmpty()) {
            for (Country c : countryList) {
                CountryView v = CountryView.from(c);
                cView.add(v);
            }
        }
        return cView;
    }

    @ExceptionHandler(RestControllerException.class)
    public ResponseEntity<ErrorResponse> RestApiExceptionHandler(RestControllerException e) {
        ErrorResponse errorResponse = ErrorResponse.from(e.getErrorCode());
        return ResponseEntity.status(e.getHttpCode()).body(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> MissingServletRequestParameterExceptionHanlder(MissingServletRequestParameterException e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST);
        return ResponseEntity.status(400).body(errorResponse);
    }
}
