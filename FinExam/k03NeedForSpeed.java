package k03FinalExamRetake;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class k03NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> distanceMap = new LinkedHashMap<>();
        Map<String, Integer> fuelMap = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfCars; i++) {
            String[] input = scanner.nextLine().split("\\|");
            String car = input[0];
            int mileage = Integer.parseInt(input[1]);
            int fuel = Integer.parseInt(input[2]);
            distanceMap.put(car, mileage);
            fuelMap.put(car, fuel);
        }
        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commandArray = command.split(" : ");
            String car = commandArray[1];

            switch (commandArray[0]) {
                case "Drive":
                    int distance = Integer.parseInt(commandArray[2]);
                    int fuel = Integer.parseInt(commandArray[3]);
                    if (fuel > fuelMap.get(car)) {
                        System.out.println("Not enough fuel to make that ride");
                    } else if (fuel <= fuelMap.get(car)) {
                        distanceMap.put(car, distanceMap.get(car) + distance);
                        fuelMap.put(car, fuelMap.get(car) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                    }
                    if (distanceMap.get(car) >= 100000) {
                        distanceMap.remove(car);
                        fuelMap.remove(car);
                        System.out.printf("Time to sell the %s!%n", car);
                    }
                    break;
                case "Refuel":
                    int fuelToTank = Integer.parseInt(commandArray[2]);
                    if (fuelMap.get(car) + fuelToTank > 75) {
                        fuelToTank = 75 - fuelMap.get(car);
                    }
                    fuelMap.put(car, fuelMap.get(car) + fuelToTank);
                    System.out.printf("%s refueled with %d liters%n", car, fuelToTank);
                    break;
                case "Revert":
                    int kilometers = Integer.parseInt(commandArray[2]);
                    distanceMap.put(car,distanceMap.get(car) - kilometers);
                    if (distanceMap.get(car)< 10000){
                        distanceMap.put(car,10000);
                    }else {
                        System.out.printf("%s mileage decreased by %d kilometers%n",car,kilometers);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry :
                distanceMap.entrySet()) {
            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",entry.getKey(),entry.getValue(),fuelMap.get(entry.getKey()));
        }
    }
}
