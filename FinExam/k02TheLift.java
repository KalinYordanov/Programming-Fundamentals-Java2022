package programmingFundamentalsMidExamRetake01;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class k02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int peopleGetOn = Integer.parseInt(scanner.nextLine());
        int[] currentState = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sumOfPeople = 0;

        for (int i = 0; i < currentState.length; i++) {
            int currentWagon = currentState[i];
            int maximum = 4 - currentState[i];
            int countPeopleToGet = Integer.min(peopleGetOn, maximum);
            currentState[i] = countPeopleToGet + currentWagon;
            peopleGetOn -= countPeopleToGet;
            sumOfPeople += currentState[i];
        }
        if (peopleGetOn > 0 && currentState.length * 4 == sumOfPeople) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleGetOn);
            print(currentState);
        } else if (peopleGetOn == 0 && currentState.length * 4 == sumOfPeople) {
            print(currentState);
        } else if (peopleGetOn == 0 && currentState.length * 4 > sumOfPeople) {
            System.out.println("The lift has empty spots!");
            print(currentState);
        }
    }

    public static void print(int[] currentState) {
        for (int i = 0; i < currentState.length; i++) {
            System.out.print(currentState[i] + " ");
        }
    }
}
