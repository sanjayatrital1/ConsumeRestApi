package com.practice.altimetrikclient.controller;

import com.practice.altimetrikclient.domain.Country;
import com.practice.altimetrikclient.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(value = "country")
public class CountryClientController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/")
    public String listAllData(Country country, HttpSession session){
        session.invalidate();
        return "input";
    }
//    @PostMapping("/")
//    public String searchCountry(Country country){
//        countryService.getAllList(country.getCountryCode(),country.getMatchRegion(),country.getIncomeLevel(),country.getLendingType());
//                return "redirect:/v1/countries";
//    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getList(Model model, @RequestParam("countryCode") String countryCode,
                          @RequestParam(value = "region", required = false) String region,
                          @RequestParam(value = "incomeLevel", required = false) String incomeLevel,
                          @RequestParam(value = "lendingType", required = false) String lendingType){
        System.out.println("+++++++++++++++++++++++++++++++++++");
        model.addAttribute("country", countryService.getAllList(countryCode,region,incomeLevel,lendingType));
        System.out.println("================================");
//        System.out.println(countryService.getAllList(countryCode));
        return "redirect:/countries";
    }

    @GetMapping("/countries")
    public String showData(){
        return "details";
    }

}
