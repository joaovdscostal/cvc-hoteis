package com.teste.cvc.model;

import lombok.Builder;

import java.util.Collections;

@Builder
public class HotelTestBuilder {

    public static Hotel createMockHotel() {
        return Hotel.builder()
                .id(1L)
                .name("Hotel Teste 1")
                .cityCode(1032L)
                .cityName("Porto Seguro")
                .rooms(Collections.singletonList(createMockRoom()))
                .build();
    }

    private static Room createMockRoom() {
        return Room.builder()
                .roomID(0L)
                .categoryName("Standard")
                .price(Price.builder().adult(1372.54).child(848.61).build())
                .build();
    }
}
