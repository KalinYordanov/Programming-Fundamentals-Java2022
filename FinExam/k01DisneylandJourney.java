package k03FinalExamRetake;

import java.util.Scanner;

public class k01DisneylandJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double cost = Double.parseDouble(scanner.nextLine());
        int numberOfMonths = Integer.parseInt(scanner.nextLine());
        double money = 0;
        double result = 0;
        for (int i = 1; i <= numberOfMonths; i++) {
            if (i % 2 != 0 && i != 1) {
                money -= money * 0.16;
            }if (i % 4 == 0){
                money += money * 0.25;
            }
            money += cost * 0.25;
        }
        if (money >= cost) {
            result = money - cost;
            System.out.printf("Bravo! You can go to Disneyland and you will have %.2flv. for souvenirs.", result);

        } else {
            result = cost - money;
            System.out.printf("Sorry. You need %.2flv. more.", result);

        }
    }
}
