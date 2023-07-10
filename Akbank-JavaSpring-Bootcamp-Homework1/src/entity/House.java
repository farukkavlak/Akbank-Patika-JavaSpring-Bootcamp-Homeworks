package entity;

import generic.Dwelling;

import java.math.BigDecimal;

public class House extends Dwelling{
    public House(BigDecimal price, double area, int roomCount, int livingRoomCount) {
        super(price, area, roomCount, livingRoomCount);
    }
}
