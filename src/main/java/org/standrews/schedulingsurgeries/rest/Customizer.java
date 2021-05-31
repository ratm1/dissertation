package org.standrews.schedulingsurgeries.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import io.quarkus.jackson.ObjectMapperCustomizer;

import javax.inject.Singleton;

@Singleton
public class Customizer implements ObjectMapperCustomizer {
    /*
    public void customize(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JodaModule());
    }
     */

    public void customize(ObjectMapper objectMapper) {
        objectMapper.registerModule(new Jdk8Module());
    }

}
