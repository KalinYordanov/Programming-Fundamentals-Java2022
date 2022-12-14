package finalExamRetake;

import java.util.Scanner;

public class k01TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder massage = new StringBuilder();
        String input = scanner.nextLine();
        while (!input.equals("Decode")) {
            String command = input.split("\\|")[0];
            switch (command) {
                case "ChangeAll":
                    String subs = input.split("\\|")[1];
                    String replacement = input.split("\\|")[2];
                    String decryptedMassage = massage.toString().replace(subs, replacement);
                    massage = new StringBuilder(decryptedMassage);
                    break;
                case "Move":
                    int numberOfLetter = Integer.parseInt(input.split("\\|")[1]);
                    String newString = (massage.substring(numberOfLetter)).concat(massage.substring(0, numberOfLetter));
                    massage = new StringBuilder(newString);
                    break;
                case "Insert":
                    int index = Integer.parseInt(input.split("\\|")[1]);
                    String value = input.split("\\|")[2];
                    String String = massage.substring(0, index).concat(value).concat(massage.substring(index));
                    massage = new StringBuilder(String);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + massage);
    }
}
