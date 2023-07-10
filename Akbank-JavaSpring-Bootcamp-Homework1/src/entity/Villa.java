package entity;

import generic.Dwelling;

import java.math.BigDecimal;

public class Villa extends Dwelling{
    public Villa(BigDecimal price, double area, int roomCount, int livingRoomCount) {
        super(price, area, roomCount, livingRoomCount);
    }
}
