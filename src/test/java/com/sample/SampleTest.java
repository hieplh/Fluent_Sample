package com.sample;

import com.config.DateTimeModule;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sample.entity.Trip;
import com.sample.entity.TripRole;
import com.sample.mapping.TripMapper;
import com.sample.mapping.TripRoleMapper;
import com.sample.request.TripRequest;
import com.sample.request.TripRoleRequest;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class SampleTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setup() {
        mapper.registerModule(new DateTimeModule());
    }

    @Test
    public void test_1() throws IOException {
        System.out.println("\nStart Test_1");
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

    @Test
    public void test_2() throws IOException {
        System.out.println("\nStart Test_2");
        String jsonRequest = "{\n" +
                "    \"id\": \"AohLPgILvbbZfw7pKqWE3\",\n" +
                "    \"name\": \"WRITE\",\n" +
                "    \"permissions\": [\n" +
                "        \"TRIP_READ\",\n" +
                "        \"TRIP_WRITE\",\n" +
                "        \"TRIP_PERMISSION\"\n" +
                "    ]\n" +
                "}";

        TripRoleRequest objRequest = mapper.readValue(jsonRequest, TripRoleRequest.class);
        TripRole role = TripRoleMapper.INSTANCE.toTripRole(objRequest);
        System.out.println(role);
    }

    @Test
    public void test_3() throws IOException {
        System.out.println("\nStart Test_3");
        String jsonRequest = "{\n" +
                "    \"title\": \"Chuyến đi đầu năm\",\n" +
                "    \"start_date\": \"2023-01-22\",\n" +
                "    \"end_date\": \"2023-01-30\",\n" +
                "    \"total_price_plan\": -1,\n" +
                "    \"total_price_actual\": -300,\n" +
                "    \"roles\": [\n" +
                "        {\n" +
                "            \"name\": \"READ\",\n" +
                "            \"permissions\": [\n" +
                "                \"TRIP_READ\"\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"name\": \"WRITE\",\n" +
                "            \"permissions\": [\n" +
                "                \"TRIP_READ\",\n" +
                "                \"TRIP_WRITE\",\n" +
                "                \"TRIP_PERMISSION\"\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        TripRequest objRequest = mapper.readValue(jsonRequest, TripRequest.class);
        Trip trip = TripMapper.INSTANCE.toTripEntityIncludeRoles(objRequest);
        System.out.println(trip);
    }
}
