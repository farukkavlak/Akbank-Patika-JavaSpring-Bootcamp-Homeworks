package generic;

import java.math.BigDecimal;

public abstract class Dwelling{
    private BigDecimal price;
    private double area;
    private int roomCount;
    private int livingRoomCount;

    public Dwelling(BigDecimal price, double area, int roomCount, int livingRoomCount) {
        this.price = price;
        this.area = area;
        this.roomCount = roomCount;
        this.livingRoomCount = livingRoomCount;
    }
    public BigDecimal getPrice() {
        return price;
    }

    public double getArea() {
        return area;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public int getLivingRoomCount() {
        return livingRoomCount;
    }

    public String toString() {
        return "Dwelling{" +
                "type=" + this.getClass().getSimpleName() +
                ", price=" + price +
                ", area=" + area +
                ", roomCount=" + roomCount +
                ", livingRoomCount=" + livingRoomCount +
                '}';
    }


}
