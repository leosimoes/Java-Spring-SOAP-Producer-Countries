package com.project.jsoapproducer;

import jakarta.xml.bind.annotation.*;

public enum CurrencyEnum {

    CAD("CAD"),
    EUR("EUR"),
    BRL("BRL");

    private final String value;

    CurrencyEnum(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CurrencyEnum fromValue(String v) {
        for (CurrencyEnum c: CurrencyEnum.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
