package com.project.jsoapproducer;

import jakarta.xml.bind.annotation.*;

@XmlType(name = "currency")
@XmlEnum
public enum Currency {

    GBP("GBP"),
    EUR("EUR"),
    PLN("PLN");

    private final String value;

    Currency(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Currency fromValue(String v) {
        for (Currency c: Currency.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
