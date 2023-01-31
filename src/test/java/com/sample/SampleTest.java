package com.sample;

import com.config.DateTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.entity.Trip;
import com.sample.mapping.TripMapper;
import com.sample.request.TripRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SampleTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        mapper.registerModule(new DateTimeModule());
    }

    @Test
    public void test_1() throws IOException {
        String jsonRequest = "{\n" +
                "    \"start_date\": \"2023-01-01\",\n" +
                "    \"end_date\": \"2023-01-03\",\n" +
                "    \"type_access\": \"PUBLIC\",\n" +
                "    \"total_price_plan\": \"100\",\n" +
                "    \"total_price_actual\": \"300\"\n" +
                "}";

        TripRequest objRequest = mapper.readValue(jsonRequest, TripRequest.class);
        Trip trip = TripMapper.INSTANCE.toTripEntity(objRequest);
        System.out.println(trip);
    }
}
