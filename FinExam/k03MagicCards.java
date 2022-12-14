package k03FinalExamRetake;
import java.util.*;
import java.util.stream.Collectors;

public class k03MagicCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String > cardList = Arrays.stream(scanner.nextLine().split(":")).collect(Collectors.toList());
        List<String> desk = new ArrayList<>();
        String input;

        while (!"Ready".equals(input = scanner.nextLine())){
            String[] command = input.split("\\s+");
            switch (command[0]){
                case "Add":
                    if (cardList.contains(command[1])){
                        desk.add(cardList.get(cardList.indexOf(command[1])));
                    }else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Remove":
                    if (desk.contains(command[1])){
                        desk.remove(command[1]);
                    }else {
                        System.out.println("Card not found.");
                    }
                    break;
                case "Shuffle":
                    Collections.reverse(desk);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command[2]);
                    if ((cardList.contains(command[1])&& (index >= 0 && index <= desk.size()))){
                        desk.add(index,command[1]);
                    }else {
                        System.out.println("Error!");
                    }
                    break;
                case "Swap":
                    Collections.swap(desk,desk.indexOf(command[1]),desk.indexOf(command[2]));
                    break;
            }
        }
        System.out.println(String.join(" ",desk));

    }
}

