package com.project.jsoapproducer;

import jakarta.xml.bind.annotation.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "country"
})
@XmlRootElement(name = "getCountryResponse")
public class GetCountryResponse {

    @XmlElement(required = true)
    protected Country country;

}