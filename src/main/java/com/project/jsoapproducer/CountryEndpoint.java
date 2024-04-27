package com.project.jsoapproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private final static String NAMESPACE_URI = "http://project.com/schema";

    private final CountryInMemoryRepository countryInMemoryRepository;

    @Autowired
    public CountryEndpoint(CountryInMemoryRepository countryInMemoryRepository){
        this.countryInMemoryRepository = countryInMemoryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest getCountryRequest){
        Country country = countryInMemoryRepository.findCountry(getCountryRequest.getName());

        return new GetCountryResponse(country);
    }

}
