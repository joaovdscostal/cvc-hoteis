package com.teste.cvc.service;

import com.teste.cvc.exception.HotelNotFoundException;
import com.teste.cvc.model.Hotel;
import com.teste.cvc.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public List<Hotel> getAvailableHotels(Long cityId) {
        return hotelRepository.findByCityCode(cityId);
    }

    public Hotel getHotelDetails(Long hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(() -> new HotelNotFoundException("Hotel not found with id: " + hotelId));
    }

    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

}
