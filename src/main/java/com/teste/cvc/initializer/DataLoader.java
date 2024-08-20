package com.teste.cvc.initializer;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.teste.cvc.model.Hotel;
import com.teste.cvc.model.Price;
import com.teste.cvc.model.Room;
import com.teste.cvc.service.HotelService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader {

    private final HotelService hotelService;

    @PostConstruct
    public void initializeData() {

        hotelService.addHotel(createHotel("Hotel Teste 1", 1032L, "Porto Seguro", createRoom("Standard", 1372.54, 848.61), createRoom("Deluxe", 1998.54, 1011.61), createRoom("Suite", 2258.54, 1265.61)));
        hotelService.addHotel(createHotel("Hotel Teste 2", 7110L, "Rio de Janeiro", createRoom("Standard", 1234.54, 789.61), createRoom("Deluxe", 1896.54, 985.61), createRoom("Suite", 2156.54, 1000.61)));
        hotelService.addHotel(createHotel("Hotel Teste 3", 9626L, "São Paulo", createRoom("Standard", 1400.54, 985.61), createRoom("Deluxe", 2024.54, 1568.61), createRoom("Suite", 3000.00, 1500.00)));
    }

    private Room createRoom(String categoryName, Double adultPrice, Double childPrice) {
    	return Room.builder()
                .categoryName(categoryName)
                .price(Price.builder().adult(adultPrice).child(childPrice).build())
                .build();
	}

	private Hotel createHotel(String name, Long cityCode, String cityName, Room... rooms) {
        return Hotel.builder()
                .name(name)
                .cityCode(cityCode)
                .cityName(cityName)
                .rooms(Arrays.asList(rooms))
                .build();
    }
}
