package programmingFundamentalsMidExamRetake01;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class tree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> distributorNameMoney = new LinkedHashMap<>();
        Map<String, Double> clientNameMoney = new LinkedHashMap<>();
        double totalMoney = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            if (command.contains("Deliver")) {
                String distName = command.split("\\s+")[1];
                double money = Double.parseDouble(command.split("\\s+")[2]);
                if (!distributorNameMoney.containsKey(distName)) {
                    distributorNameMoney.put(distName, money);
                } else {
                    double moneySpend = distributorNameMoney.get(distName);
                    distributorNameMoney.put(distName, moneySpend + money);
                }
            } else if (command.contains("Return")) {
                String distName = command.split("\\s+")[1];
                double moneyForReturn = Double.parseDouble(command.split("\\s+")[2]);
                if (distributorNameMoney.containsKey(distName)) {
                    double moneySpend = distributorNameMoney.get(distName);
                    if (moneySpend >= moneyForReturn) {
                        distributorNameMoney.put(distName, moneySpend - moneyForReturn);
                        if (distributorNameMoney.get(distName) == 0) {
                            distributorNameMoney.remove(distName);
                        }
                    }
                }
            }else if (command.contains("Sell")){
                String clientName = command.split("\\s+")[1];
                double money = Double.parseDouble(command.split("\\s+")[2]);
                totalMoney += money;
                if (!clientNameMoney.containsKey(clientName)){
                    clientNameMoney.put(clientName,money);
                }else {
                    double currentMoney = clientNameMoney.get(clientName);
                    clientNameMoney.put(clientName,currentMoney + money);
                }

            }
            command = scanner.nextLine();
        }
        clientNameMoney.entrySet().forEach(stringDoubleEntry -> {
            System.out.printf("%s: %.2f%n", stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
        });
        System.out.println("-----------");
        distributorNameMoney.entrySet().forEach(stringDoubleEntry -> {
            System.out.printf("%s: %.2f%n", stringDoubleEntry.getKey(), stringDoubleEntry.getValue());
        });
        System.out.println("-----------");
        System.out.printf("Total Income: %.2f%n",totalMoney);

    }
}
