package com.practice.com.altrimetrikdemo.repository;

import com.practice.com.altrimetrikdemo.worldbank.Country;
import com.practice.com.altrimetrikdemo.worldbank.Pages;
import com.practice.com.altrimetrikdemo.worldbank.WorldBankCountryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Country,Long> {

    @Query(value = " select distinct * from country c , region r where c.iso2code=?1 or (r.value =?2 and r.value =?3 and r.value=?4 )" , nativeQuery = true)
    public List<Country>searchCountry(@Param("countryCode") String countryCode,  @Param("incomeLevel") String incomeLevel,@Param("region") String region, @Param("lendingType") String lendingType);

}
