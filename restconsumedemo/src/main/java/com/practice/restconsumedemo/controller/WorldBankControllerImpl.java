package com.practice.restconsumedemo.controller;

import com.practice.restconsumedemo.domain.CountryView;
import com.practice.restconsumedemo.domain.ErrorCode;
import com.practice.restconsumedemo.domain.ErrorResponse;
import com.practice.restconsumedemo.service.WorldBankService;
import com.practice.restconsumedemo.domain.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin(origins = "*" , allowedHeaders = "*")
public class WorldBankControllerImpl implements WorldBankController {

    @Autowired
    private WorldBankService worldBankService;

    @Override
    @GetMapping("v1/country")
    public ResponseEntity<List<CountryView>> searchCountry(@RequestParam(value = "countryCode" , required = true) String countryCode,
                                           @RequestParam(value = "region", required = false)String region,
                                           @RequestParam(value = "incomeLabel" , required = false) String incomeLevel,
                                           @RequestParam(value = "lendingType" , required = false) String lendingType) {
        System.out.println("In Controller============================");
        System.out.println("CountryCode="+countryCode+"  region ="+region+" Income Level ="+incomeLevel+" Lending Type = "+lendingType);
        System.out.println("++++++++++++++++++++++++++++++End Controller");
        if (countryCode == null || countryCode.trim().isEmpty()) {
            throw new RestControllerException(ErrorCode.BAD_REQUEST, 400, "Country Code is missing");
        }

        Collection<Country> countryList= worldBankService.searchCountires(countryCode,region,incomeLevel,lendingType);

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
//        HttpHeaders h = new HttpHeaders();
//        h.set("Access-Control-Allow-Origin", "*");

        return ResponseEntity.ok().body(cView);
    }

    @ExceptionHandler(RestControllerException.class) /* To catch the RestController Exception thrown by controller class*/
    public ResponseEntity<ErrorResponse> RestApiExceptionHandler(RestControllerException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.getErrorCode(), e.getMessage());
        return ResponseEntity.status(e.getHttpCode()).body(errorResponse);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> MissingServletRequestParameterExceptionHanlder(MissingServletRequestParameterException e) {
        ErrorResponse errorResponse = new ErrorResponse(ErrorCode.BAD_REQUEST);
        return ResponseEntity.status(400).body(errorResponse);
    }
}
