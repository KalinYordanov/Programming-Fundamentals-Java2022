package programmingFundamentalsMidExamRetake01;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class k03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> elements = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input;
        int movies = 0;
        while (!"end".equals(input = scanner.nextLine())) {
            movies++;
            int[] index = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            if ((index[0] == index[1]) || (index[0] < 0 || index[0] >= elements.size()) || index[1] < 0 || index[1] >= elements.size()) {
                System.out.println("Invalid input! Adding additional elements to the board");
                elements.add(elements.size() / 2, "-" + movies + "a");
                elements.add(elements.size() / 2, "-" + movies + "a");
            }else {
                if (elements.get(index[0]).equals(elements.get(index[1]))){
                    System.out.printf("Congrats! You have found matching elements - %s!%n",elements.get(index[0]));
                    elements.remove(Math.max(index[0],index[1]));
                    elements.remove(Math.min(index[0],index[1]));
                }else {
                    System.out.println("Try again!");
                }
                if (elements.isEmpty()){
                    System.out.printf("You have won in %d turns!%n",movies);
                    return;
                }
            }
        }
        System.out.printf("Sorry you lose :(%n");
        System.out.println(String.join(" ",elements));
    }
}
