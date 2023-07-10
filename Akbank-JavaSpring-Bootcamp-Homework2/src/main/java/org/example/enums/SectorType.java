package org.example.enums;

public enum SectorType {
    FOOD,
    TECHNOLOGY,
    HEALTH,
    FINANCE,
    EDUCATION,
    ENERGY,
    TRANSPORTATION,
    COMMUNICATION,
    TOURISM,
    ENTERTAINMENT,
    OTHER ;

    @Override
    public String toString() {
        return this.name();
    }
}
