package com.project.jsoapproducer;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryInMemoryRepository {

    private static final Map<String, CountryEntity> countriesMap = new HashMap<>();

    @PostConstruct
    public void initData(){
        CountryEntity brazil = CountryEntity
                .builder()
                .name("Brazil")
                .capital("Brasilia")
                .currency(CurrencyEnum.BRL)
                .population(217418169)
                .build();

        CountryInMemoryRepository.countriesMap.put(brazil.getName(), brazil);

        CountryEntity portugal = CountryEntity
                .builder()
                .name("Portugal")
                .capital("Lisbon")
                .currency(CurrencyEnum.EUR)
                .population(10227645)
                .build();

        CountryInMemoryRepository.countriesMap.put(portugal.getName(), portugal);

        CountryEntity canada = CountryEntity
                .builder()
                .name("Canada")
                .capital("Ottawa")
                .currency(CurrencyEnum.CAD)
                .population(39049558)
                .build();

        CountryInMemoryRepository.countriesMap.put(canada.getName(), canada);
    }

    public CountryEntity findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return CountryInMemoryRepository.countriesMap.get(name);
    }
}
