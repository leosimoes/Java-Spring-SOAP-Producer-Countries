package com.project.jsoapproducer;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.Currency;

public class CountryMapper {

    public static Country toCountrySOAP(CountryEntity countryEntity){
        Currency currency = Currency.fromValue(countryEntity.getCurrency().value());
        Country countrySOAP = new Country();
        countrySOAP.setName(countryEntity.getName());
        countrySOAP.setCapital(countryEntity.getCapital());
        countrySOAP.setPopulation(countryEntity.getPopulation());
        countrySOAP.setCurrency(currency);

        return countrySOAP;
    }

}
