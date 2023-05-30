package core.basesyntax;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, Integer> map = new HashMap<>();
        List<String> strings = Files.readAllLines(Path.of("src/main/resources/DatabaseOfShop.csv")).stream().filter(x -> !x.contains("type")).toList();
        List<FruitTransaction> transactions = new ArrayList<>();
        TransactionParser parser = new TransactionParser();
        for (String string : strings) {
            FruitTransaction fruitTransaction = parser.parse(string);
            transactions.add(fruitTransaction);
        }

        List<FruitTransaction> balanceTransaction = transactions.stream().filter(t -> t.getOperation() == FruitTransaction.Operation.BALANCE)
                .toList();

        for (FruitTransaction fruitTransaction : balanceTransaction) {
            map.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        }

        List<FruitTransaction> otherTransactions = transactions.stream().filter(t -> t.getOperation() != FruitTransaction.Operation.BALANCE).toList();
        for (FruitTransaction transaction : otherTransactions) {
            String fruit = transaction.getFruit();
            FruitTransaction.Operation operation = transaction.getOperation();
            Integer quantity = transaction.getQuantity();
            Integer integer = map.get(fruit);
            switch (operation) {
                case SUPPLY, RETURN -> integer += quantity;
                case PURCHASE -> integer -= quantity;
            }
            map.put(fruit, integer);
        }
        String csvFileName = "src/main/resources/output.csv";
        try (FileWriter writer = new FileWriter(csvFileName)) {
            writer.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                String fruit = entry.getKey();
                int quantity = entry.getValue();
                writer.write(fruit + "," + quantity + "\n");
            }
            System.out.println("CSV file created successfully.");
        } catch (IOException e) {
            System.out.println("Error occurred while creating CSV file.");
            e.printStackTrace();
        }
    }
}
