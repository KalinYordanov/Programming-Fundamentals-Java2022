package finalExamRetake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class k03ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<String>> playlist = new ArrayList<>();
        List list;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\|");
            list = Arrays.stream(input).collect(Collectors.toList());
            playlist.add(list);
        }
        String[] command = scanner.nextLine().split("\\|");
        while (!command[0].equals("Stop")) {
            boolean isThere = false;
            switch (command[0]) {
                case "Add":
                    for (int i = 0; i < playlist.size(); i++) {
                        if (playlist.get(i).contains(command[1])) {
                            isThere = true;
                            System.out.printf("%s is already in the collection!%n", command[1]);
                            break;
                        }
                    }
                    if (!isThere) {
                        System.out.printf("%s by %s in %s added to the collection!%n", command[1], command[2], command[3]);
                        list = Arrays.stream(Arrays.copyOfRange(command, 1, 4)).collect(Collectors.toList());
                        playlist.add(list);
                    }
                    break;
                case "Remove":
                    for (int i = 0; i < playlist.size(); i++) {
                        if (playlist.get(i).contains(command[1])) {
                            isThere = true;
                            System.out.printf("Successfully removed %s!%n", command[1]);
                            playlist.remove(i);

                        }
                    }
                    if (!isThere) {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", command[1]);
                    }
                    break;
                case "ChangeKey":
                    for (int i = 0; i < playlist.size(); i++) {
                        if (playlist.get(i).get(0).equals(command[1])) {
                            isThere = true;
                            playlist.get(i).add(command[2]);
                            playlist.get(i).remove(2);
                            System.out.printf("Changed the key of %s to %s!%n", playlist.get(i).get(0), command[2]);
                        }
                    } if (!isThere){
                    System.out.printf("Invalid operation! %s does not exist in the collection.%n",command[1]);
                }
                    break;
            }
            command = scanner.nextLine().split("\\|");
        }
        for (int i = 0; i < playlist.size(); i++) {
            System.out.printf("%s -> Composer: %s, Key: %s%n",playlist.get(i).get(0),playlist.get(i).get(1),playlist.get(i).get(2));
        }
    }
}
