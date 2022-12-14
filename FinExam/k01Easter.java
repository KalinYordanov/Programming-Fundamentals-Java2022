package programmingFundamentalsMidExamRetake01;

import java.util.Locale;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String command = scanner.nextLine();

        while (!command.equals("Easter")) {
            if (command.contains("Replace")) {
                String current = command.split("\\s+")[1];
                String newChar = command.split("\\s+")[2];
                String newCh = text.replaceAll(current, newChar);
                text = newCh;
                System.out.println(newCh);

            } else if (command.contains("Remove")) {
                String textToRemove = command.split("\\s+")[1];
                String remove = text.replaceAll(textToRemove, "");
                text = remove;
                System.out.println(remove);

            } else if (command.contains("Includes")) {
                String includes = command.split("\\s+")[1];
                if (text.contains(includes)) {
                    System.out.println("True");
                } else {
                    System.out.println("False");
                }
            } else if (command.contains("Change")) {
                String textCommand = command.split("\\s+")[1];
                if (textCommand.contains("Lower")) {
                    text = text.toLowerCase(Locale.ROOT);
                    System.out.println(text.toLowerCase(Locale.ROOT));
                } else if (textCommand.contains("Upper")) {
                    text = text.toUpperCase(Locale.ROOT);
                    System.out.println(text.toUpperCase(Locale.ROOT));
                }

            } else if (command.contains("Reverse")) {

                int startInd = Integer.parseInt(command.split("\\s+")[1]);
                int endInd = Integer.parseInt(command.split("\\s+")[2]);
                if (startInd >= 0 && endInd > 0 && startInd <= text.length() - 1 && endInd <= text.length() - 1) {

                    String subs = text.substring(startInd ,endInd + 1);
                    StringBuilder sb = new StringBuilder();
                    System.out.println(sb.append(subs).reverse());
                }
            }
            command = scanner.nextLine();
        }


    }
}
