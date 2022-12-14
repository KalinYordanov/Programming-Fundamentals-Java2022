package programmingFundamentalsMidExamRetake01;

import java.util.Scanner;

public class k01ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceSum = 0;
        String input = scanner.nextLine();

        while (!input.equals("special") && !input.equals("regular")) {
            double price = Double.parseDouble(input);
            if (price < 0) {
                System.out.println("Invalid price!");
            } else {
                priceSum += price;
            }
            input = scanner.nextLine();
        }
        double taxes = priceSum * 0.2;
        double totalSum = priceSum + taxes;
        if (input.equals("special")){
                totalSum *= 0.9;
        }
            if (totalSum == 0){
                System.out.println("Invalid order!");
            }else {
                System.out.printf("Congratulations you've just bought a new computer!%nPrice " +
                        "without taxes: %.2f$%nTaxes: %.2f$%n-----------%nTotal price: %.2f$",priceSum,taxes,totalSum);
            }

    }
}
