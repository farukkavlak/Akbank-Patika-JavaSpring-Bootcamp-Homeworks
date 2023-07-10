package service;

import dao.DwellingDao;
import generic.Dwelling;

import java.math.BigDecimal;
import java.util.List;

public class DwellingService {
    private final DwellingDao dwellingDao;

    public DwellingService() {
        this.dwellingDao = new DwellingDao();
    }

    //Util methods
    private BigDecimal calculateTotalPrice(List<Dwelling> dwellingList) {
        return dwellingList.stream().map(Dwelling::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private double calculateAverageArea(List<Dwelling> dwellingList) {
        return dwellingList.stream().mapToDouble(Dwelling::getArea).average().orElse(0.0);
    }

    public BigDecimal getTotalPrice() {
        return calculateTotalPrice(dwellingDao.findAll());
    }


    public double getAverageArea() {
        return calculateAverageArea(dwellingDao.findAll());
    }

    public BigDecimal getTotalHousePrice() {
        return calculateTotalPrice(dwellingDao.findAllByType("House"));
    }

    public BigDecimal getTotalVillaPrice() {
        return calculateTotalPrice(dwellingDao.findAllByType("Villa"));
    }

    public BigDecimal getTotalSummerhousePrice() {
        return calculateTotalPrice(dwellingDao.findAllByType("Summerhouse"));
    }

    public double getAverageHouseArea() {
        return calculateAverageArea(dwellingDao.findAllByType("House"));
    }

    public double getAverageVillaArea() {
        return calculateAverageArea(dwellingDao.findAllByType("Villa"));
    }

    public double getAverageSummerhouseArea() {
        return calculateAverageArea(dwellingDao.findAllByType("Summerhouse"));
    }

    public List<Dwelling> findAllByRoomAndLivingRoomCount(int roomCount, int livingRoomCount) {
        //Return all dwellings with given room and living room count
        return dwellingDao.findAll().stream().filter(dwelling -> dwelling.getRoomCount() == roomCount && dwelling.getLivingRoomCount() == livingRoomCount).toList();
    }


}
