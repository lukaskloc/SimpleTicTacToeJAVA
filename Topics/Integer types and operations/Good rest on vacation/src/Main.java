import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int daysOfDuration = scanner.nextInt();
        int totalFoodCostPerDay = scanner.nextInt();
        int oneWayFlightCost = scanner.nextInt();
        int costOfOneNightInHotel = scanner.nextInt();

        int totalCost = (daysOfDuration - 1) * costOfOneNightInHotel + totalFoodCostPerDay * daysOfDuration +
                oneWayFlightCost * 2;

        System.out.println(totalCost);
    }
}
