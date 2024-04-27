package com.project.jsoapproducer;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryInMemoryRepository {

    private static final Map<String, Country> countriesMap = new HashMap<>();

    @PostConstruct
    public void initData(){
        Country brazil = Country
                .builder()
                .name("Brazil")
                .capital("Brasilia")
                .currency(Currency.BRL)
                .population(217418169)
                .build();

        CountryInMemoryRepository.countriesMap.put(brazil.getName(), brazil);

        Country portugal = Country
                .builder()
                .name("Portugal")
                .capital("Lisbon")
                .currency(Currency.EUR)
                .population(10227645)
                .build();

        CountryInMemoryRepository.countriesMap.put(portugal.getName(), portugal);

        Country canada = Country
                .builder()
                .name("Canada")
                .capital("Ottawa")
                .currency(Currency.CAD)
                .population(39049558)
                .build();

        CountryInMemoryRepository.countriesMap.put(canada.getName(), canada);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return CountryInMemoryRepository.countriesMap.get(name);
    }
}
