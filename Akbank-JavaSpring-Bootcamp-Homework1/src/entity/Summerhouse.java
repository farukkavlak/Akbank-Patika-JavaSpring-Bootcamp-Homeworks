package entity;

import generic.Dwelling;

import java.math.BigDecimal;

public class Summerhouse extends Dwelling {
    public Summerhouse(BigDecimal price, double area, int roomCount, int livingRoomCount) {
        super(price, area, roomCount, livingRoomCount);
    }
}
