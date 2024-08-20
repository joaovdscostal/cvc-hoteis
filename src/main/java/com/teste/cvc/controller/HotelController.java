package com.teste.cvc.controller;

import com.teste.cvc.model.Hotel;
import com.teste.cvc.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/avail/{cityId}")
    public ResponseEntity<List<Hotel>> getAvailableHotels(@PathVariable("cityId") Long cityId) {
        List<Hotel> hotels = hotelService.getAvailableHotels(cityId);
        return ResponseEntity.ok(hotels);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelDetails(@PathVariable("hotelId") Long hotelId) {
        Hotel hotel = hotelService.getHotelDetails(hotelId);
        return ResponseEntity.ok(hotel);
    }
}
