package com.project.jsoapproducer;

import jakarta.xml.bind.annotation.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CountryEntity {

    private String name;

    private int population;

    private String capital;

    private CurrencyEnum currency;
}
