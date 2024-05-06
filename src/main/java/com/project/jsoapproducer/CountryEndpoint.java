package com.project.jsoapproducer;

import io.spring.guides.gs_producing_web_service.Country;
import io.spring.guides.gs_producing_web_service.GetCountryRequest;
import io.spring.guides.gs_producing_web_service.GetCountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class CountryEndpoint {

    private final static String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private final CountryInMemoryRepository countryInMemoryRepository;

    @Autowired
    public CountryEndpoint(CountryInMemoryRepository countryInMemoryRepository){
        this.countryInMemoryRepository = countryInMemoryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest getCountryRequest){
        CountryEntity countryEntity = countryInMemoryRepository.findCountry(getCountryRequest.getName());
        Country countrySOAP = CountryMapper.toCountrySOAP(countryEntity);

        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countrySOAP);

        return response;
    }

}
