package k03FinalExamRetake;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class k02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        Map<String, String> words = new LinkedHashMap<>();
        Pattern pattern = Pattern.compile("([@#])([A-Za-z]{3,})\\1\\1([A-Za-z]{3,})\\1");
        Matcher matcher = pattern.matcher(text);
        int countValid = 0;
        while (matcher.find()) {
            String word = matcher.group().replace("@", "").replace("#", "");
            countValid++;
            String first = word.substring(0, (word.length() / 2));
            String second = word.substring(word.length() / 2);
            StringBuilder sec = new StringBuilder(second);
            sec.reverse();
            if (first.equals(sec.toString())){
                words.put(first,second);
            }
        }
            if (countValid == 0){
                System.out.println("No word pairs found!");
            }else {
                System.out.println(countValid + " word pairs found!");
            }
            if (words.size() == 0){
                System.out.println("No mirror words!");
            } else {
                System.out.println("The mirror words are:");
                List<String> result = new ArrayList<>();
                for (Map.Entry<String, String> entry :
                        words.entrySet()) {
                    result.add(entry.getKey() + " <=> " + entry.getValue());
                }
                System.out.println(String.join(", ",result));
            }

    }
}
