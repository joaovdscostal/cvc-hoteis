package com.teste.cvc.service;

import com.teste.cvc.model.Hotel;
import com.teste.cvc.model.HotelTestBuilder;
import com.teste.cvc.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class HotelServiceTest {

    @Mock
    private HotelRepository hotelRepository;

    @InjectMocks
    private HotelService hotelService;

    @Test
    void testGetAvailableHotels() {
        when(hotelRepository.findByCityCode(any())).thenReturn(Collections.singletonList(HotelTestBuilder.createMockHotel()));
        List<Hotel> hotels = hotelService.getAvailableHotels(1032L);
        assertEquals(1, hotels.size());
    }

    @Test
    void testGetHotelDetails() {
        when(hotelRepository.findById(any())).thenReturn(Optional.of(HotelTestBuilder.createMockHotel()));
        Hotel hotel = hotelService.getHotelDetails(1L);
        assertEquals("Hotel Teste 1", hotel.getName());
    }
}
