package fundamentalsFinalExam;

import java.util.Scanner;

public class k1WorldTour {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String destinations = scan.nextLine();
        String input = scan.nextLine();

        while (!"Travel".equals(input)) {
            String[] tokens = input.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add Stop": {
                    int index = Integer.parseInt(tokens[1]);
                    String toInsert = tokens[2];

                    if (validIndex(destinations, index)) {
                        destinations = addStop(destinations, index, toInsert);
                    }

                    System.out.println(destinations);

                    break;
                }
                case "Remove Stop": {
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);

                    if (validIndex(destinations, startIndex) && validIndex(destinations, endIndex)) {
                        destinations = removeStop(destinations, startIndex, endIndex);
                    }

                    System.out.println(destinations);

                    break;
                }
                case "Switch": {
                    String oldString = tokens[1];
                    String newString = tokens[2];

                    destinations = destinations.replace(oldString, newString);
                    System.out.println(destinations);

                    break;
                }
            }

            input = scan.nextLine();
        }

        System.out.printf("Ready for world tour! Planned stops: %s", destinations);
    }

    private static String removeStop(String destinations, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < destinations.length(); i++) {
            if (i >= startIndex && i <= endIndex)
                continue;

            sb.append(destinations.charAt(i));
        }

        return sb.toString();
    }

    private static String addStop(String destinations, int index, String toInsert) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < index; i++) {
            sb.append(destinations.charAt(i));
        }

        for (int i = 0; i < toInsert.length(); i++) {
            sb.append(toInsert.charAt(i));
        }

        for (int i = index; i < destinations.length(); i++) {
            sb.append(destinations.charAt(i));
        }

        return sb.toString();
    }

    private static boolean validIndex(String destinations, int index) {
        return index >= 0 && index < destinations.length();
    }
}
