package com.otelRezervasyonu.tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class UpdateBookingTests extends BaseTest{
    @Test
    void updateBookingTest(){
        Response response= given(spec)
                .contentType(ContentType.JSON)
                .header("Cookie","token="+createToken())
                .body(bookingObject("Sevi","Can",500, false))
                .put("/booking/"+createBookingId());

        String firstname = response.jsonPath().getJsonObject("firstname");
        String lastname = response.jsonPath().getJsonObject("lastname");
        int totalprice = response.jsonPath().getJsonObject("totalprice");
        boolean depositPaid=response.jsonPath().getJsonObject("depositpaid");


        Assertions.assertEquals("Sevi", firstname);
        Assertions.assertEquals("Can", lastname);
        Assertions.assertEquals(500, totalprice);
        Assertions.assertEquals(false, depositPaid);

    }


}
