package com.example.cardsservice.services;

import com.example.dtos.doctors.DoctorWithIdDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class DoctorClient {
    private final RestTemplate restTemplate;


    @Value("${doctors.base-url}")
    private String baseUrl;

    @Autowired
    public DoctorClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<DoctorWithIdDTO> getDoctors(Boolean available, String specialization) {
        String uriString = builder(baseUrl)
                .available(available)
                .specialization(specialization)
                .build();

        DoctorWithIdDTO[] arr = requestOrDefault(uriString, new DoctorWithIdDTO[] {}, DoctorWithIdDTO[].class);

        return Arrays.asList(arr);
    }

    private <T> T requestOrDefault(String uri, T defaultObject, Class<T> clazz) {
        return Optional.ofNullable(restTemplate.getForObject(uri, clazz)).orElse(defaultObject);
    }


    private RequestBuilder builder(String baseUrl) {
        return new RequestBuilder(baseUrl);
    }

    public static class RequestBuilder {
        private static final String AVAILABLE = "available";
        private static final String SPECIALIZATION = "specialization";

        private Boolean available;
        private String specialization;
        private final UriComponentsBuilder uriComponentsBuilder;


        public RequestBuilder(String baseUrl) {
            uriComponentsBuilder = UriComponentsBuilder.fromUriString(baseUrl);
        }

        public RequestBuilder available(Boolean available) {
            this.available = available;
            return this;
        }

        public RequestBuilder specialization(String specialization) {
            this.specialization = specialization;
            return this;
        }

        public String build() {
            uriComponentsBuilder
                    .queryParamIfPresent(AVAILABLE, Optional.ofNullable(available))
                    .queryParamIfPresent(SPECIALIZATION, Optional.ofNullable(specialization));

            return uriComponentsBuilder.toUriString();
        }
    }


}
