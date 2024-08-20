package com.teste.cvc.controller;

import com.teste.cvc.model.HotelTestBuilder;
import com.teste.cvc.service.HotelService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class HotelControllerTest {

    @Mock
    private HotelService hotelService;

    @InjectMocks
    private HotelController hotelController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetAvailableHotels() throws Exception {
        when(hotelService.getAvailableHotels(1032L)).thenReturn(Collections.singletonList(HotelTestBuilder.createMockHotel()));
        mockMvc.perform(MockMvcRequestBuilders.get("/hotels/avail/1032")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testGetHotelDetails() throws Exception {
        when(hotelService.getHotelDetails(1L)).thenReturn(HotelTestBuilder.createMockHotel());
        mockMvc.perform(MockMvcRequestBuilders.get("/hotels/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
