package programmingFundamentalsMidExamRetake01;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int registrations = 0;
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            String regex = "(U\\$)(?<username>[A-Z][a-z]{2,})\\1(P@\\$)(?<password>[a-z]{5,}[0-9]{1,})\\3";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(text);
            if (matcher.find()){
                String name = matcher.group("username");
                String password = matcher.group("password");
                System.out.printf("Registration was successful%n");
                System.out.printf("Username: %s, Password: %s%n",name,password);
                registrations ++;
            }else {
                System.out.printf("Invalid username or password%n");
            }
        }
        System.out.printf("Successful registrations: %d",registrations);

    }
}
