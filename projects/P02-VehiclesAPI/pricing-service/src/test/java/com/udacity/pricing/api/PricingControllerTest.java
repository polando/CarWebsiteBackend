package com.udacity.pricing.api;

import com.udacity.pricing.entity.Price;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PricingControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void testGetPriceById() {
        ResponseEntity<Price> response =
                restTemplate.getForEntity("http://localhost:" + port + "/prices/search/findByVehicleId?vehicleId=1", Price.class);

        assertEquals( HttpStatus.OK,response.getStatusCode());
        assertEquals(1000L,Objects.requireNonNull(response.getBody()).getPrice().longValue());
        assertEquals("USD",response.getBody().getCurrency());
        assertEquals(1L,response.getBody().getVehicleId().longValue());

    }


}
