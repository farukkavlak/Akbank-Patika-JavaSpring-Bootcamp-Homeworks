import service.DwellingService;

public class Main {
    private static final DwellingService dwellingService = new DwellingService();

    public static void main(String[] args) {
        System.out.println("Total price of dwellings that type is House: " + dwellingService.getTotalHousePrice());
        System.out.println("Total price of dwellings that type is Villa: " + dwellingService.getTotalVillaPrice());
        System.out.println("Total price of dwellings that type is Summerhouse: " + dwellingService.getTotalSummerhousePrice());
        System.out.println("Total price of all dwellings: " + dwellingService.getTotalPrice());
        System.out.println("-----------------------------------------");
        System.out.println("Average area of dwellings that type is House: " + dwellingService.getAverageHouseArea());
        System.out.println("Average area of dwellings that type is Villa: " + dwellingService.getAverageVillaArea());
        System.out.println("Average area of dwellings that type is Summerhouse: " + dwellingService.getAverageSummerhouseArea());
        System.out.println("Average area of all dwellings: " + dwellingService.getAverageArea());
        System.out.println("-----------------------------------------");
        System.out.println("Dwellings that have 3 rooms and 1 living room: " + dwellingService.findAllByRoomAndLivingRoomCount(3, 1));
        System.out.println("Dwellings that have 4 rooms and 1 living room: " + dwellingService.findAllByRoomAndLivingRoomCount(4, 1));
        System.out.println("Dwellings that have 2 rooms and 1 living room: " + dwellingService.findAllByRoomAndLivingRoomCount(2, 1));



    }
}