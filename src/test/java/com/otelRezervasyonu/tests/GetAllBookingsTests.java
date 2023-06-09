package com.otelRezervasyonu.tests;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllBookingsTests extends BaseTest{
    @Test
    public void getAllBookingTest(){
        given(spec)
                .when()
                .get("/booking")
                .then()
                .statusCode(200);
    }

    @Test
    public void getBooking_with_firstname_filter_test(){
        int bookingId=createBookingId();
        spec.queryParam("firstname", "Deniz");
        spec.queryParam("lastname", "Albayrak");

        Response response = given(spec)
                .when()
                .get("/booking");

        response
                .then()
                .statusCode(200);

        List<Integer> filtrelenenRezervasyon=response.jsonPath().getList("bookingid");
        Assertions.assertTrue(filtrelenenRezervasyon.contains(bookingId));

    }
}
