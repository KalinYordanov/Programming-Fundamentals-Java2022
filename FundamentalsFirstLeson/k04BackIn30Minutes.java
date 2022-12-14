import java.util.Scanner;

public class k04BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int allMinutes = (hour * 60) + minutes + 30;
        int ounHour = allMinutes / 60;
        int ourMinuts = allMinutes % 60;
        if (ounHour>23){
            ounHour = 0;
        }
        System.out.printf("%d:%02d",ounHour ,ourMinuts);

    }
}
