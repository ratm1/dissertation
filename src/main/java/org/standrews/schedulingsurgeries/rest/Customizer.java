package org.standrews.schedulingsurgeries.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;

@Singleton
public class Customizer implements ObjectMapperCustomizer {
    public void customize(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JodaModule());
    }
}
