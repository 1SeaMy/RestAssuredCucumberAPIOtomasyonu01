package com.otelRezervasyonu.tests;

import com.otelRezervasyonu.models.Booking;
import com.otelRezervasyonu.models.BookingDates;

import com.otelRezervasyonu.models.BookingResponse;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;


public class CreateBookingTests extends BaseTest{
    @Test
    public void createBookingTest (){
        Response response = createBooking();

        Assertions.assertEquals("Deniz", response.jsonPath().getJsonObject("booking.firstname"));
        Assertions.assertEquals("Albayrak", response.jsonPath().getJsonObject("booking.lastname"));
        Assertions.assertEquals(1000, (Integer)response.jsonPath().getJsonObject("booking.totalprice"));
        Assertions.assertEquals(true, (boolean)response.jsonPath().getJsonObject("booking.depositpaid"));

    }
//    @Test
//    public void createBookingWithPojo(){
//        BookingDates bookingDates = new BookingDates("2023-10-10","2023-10-15");
//        Booking booking =new Booking("Batu", "Albay", 500, false, bookingDates,"haycan yolcu");
//
//        Response response = given(spec)
//                .contentType(ContentType.JSON)
//                .body(booking)
//                .when()
//                .post("/booking");
//
//        response
//                .then()
//                .statusCode(500);
//
//        BookingResponse bookingResponse=response.as(BookingResponse.class);
//
//        System.out.println(bookingResponse);
//
//    }
}
