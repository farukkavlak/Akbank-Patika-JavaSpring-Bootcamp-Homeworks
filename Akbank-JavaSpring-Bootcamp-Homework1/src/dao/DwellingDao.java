package dao;

import entity.House;
import entity.Summerhouse;
import entity.Villa;
import generic.Dwelling;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DwellingDao {
    private List<Dwelling> dwellingList = new ArrayList<Dwelling>();
    private static Random random = new Random();


    public DwellingDao() {
        initDwellingList();
    }
    private void initDwellingList() {
        //Create 3 different dwelling objects with random attributes and add them to the list per each type: House, Villa, Summerhouse
        dwellingList.addAll(createDwellings(3,"HOUSE"));
        dwellingList.addAll(createDwellings(3,"VILLA"));
        dwellingList.addAll(createDwellings(3,"SUMMERHOUSE"));
    }

    private static List<Dwelling> createDwellings(int count, String type) {
        return Stream.generate(() -> createDwelling((type)))
                .limit(count)
                .collect(Collectors.toList());
    }

    private static Dwelling createDwelling(String type) {
        //Range of random price: 100.000 - 500.000
        BigDecimal randomPrice = new BigDecimal(random.nextDouble() * 400000 + 100000);
        //Range of random area: 50 - 250
        double randomArea = random.nextInt(200) + 50;
        //Range of random room count: 1 - 6
        int randomRoomCount = random.nextInt(5) + 1;
        //Range of random living room count: 1 - 3
        int randomLivingRoomCount = random.nextInt(3) + 1;

        switch (type) {
            case "HOUSE":
                return new House(randomPrice, randomArea, randomRoomCount, randomLivingRoomCount);
            case "VILLA":
                return new Villa(randomPrice, randomArea, randomRoomCount, randomLivingRoomCount);
            case "SUMMERHOUSE":
                return new Summerhouse(randomPrice, randomArea, randomRoomCount, randomLivingRoomCount);
            default:
                throw new IllegalArgumentException("Invalid dwelling type: " + type);
        }
    }

    public List<Dwelling> findAll() {
        return dwellingList;
    }

    public List<Dwelling> findAllByType(String type) {
        return dwellingList.stream()
                .filter(dwelling -> dwelling.getClass().getSimpleName().equals(type))
                .collect(Collectors.toList());
    }
}
