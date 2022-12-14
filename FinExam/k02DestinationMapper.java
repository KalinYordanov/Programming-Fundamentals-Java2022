package fundamentalsFinalExam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = "(=|\\/)(?<Destination>[A-Z][A-za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        List<String> destination = new ArrayList<>();

        while (matcher.find()) {
            String currentDestination = matcher.group("Destination");
            destination.add(currentDestination);
        }
        int travelPoint = 0;
        for (String currentDestination : destination) {
            int currentPont = Integer.parseInt(String.valueOf(currentDestination.length()));
            travelPoint += currentPont;
        }
        System.out.print("Destinations: ");
        if (destination.isEmpty()) {
            System.out.println();
        }
        for (int index = 0; index < destination.size(); index++) {
            if (index != destination.size() - 1) {
                System.out.print(destination.get(index) + ", ");
            } else {
                System.out.println(destination.get(index));
            }
        }
        System.out.println("Travel Points: " + travelPoint);
    }
}
