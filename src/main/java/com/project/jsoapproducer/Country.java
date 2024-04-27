package com.project.jsoapproducer;

import jakarta.xml.bind.annotation.*;
import lombok.Builder;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "name",
        "population",
        "capital",
        "currency"
})

@Data
@Builder
@XmlRootElement(name = "country")
public class Country {

    @XmlElement(required = true)
    protected String name;
    protected int population;
    @XmlElement(required = true)
    protected String capital;
    @XmlElement(required = true)
    protected Currency currency;
}
