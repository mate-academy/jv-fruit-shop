package core.basesyntax;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FruitStorage fruitStorage = new FruitStorage();
        fruitStorage.addQuantity("banana", 100);
        fruitStorage.addQuantity("apple", 200);
        fruitStorage.addQuantity("orange", 300);
        fruitStorage.addQuantity("lemon", 400);
        fruitStorage.addQuantity("avocado", 500);

        fruitStorage.subtractQuantity("banana", 50);
        fruitStorage.subtractQuantity("apple", 100);
        fruitStorage.subtractQuantity("orange", 150);
        fruitStorage.subtractQuantity("lemon", 200);
        fruitStorage.subtractQuantity("avocado", 250);

        fruitStorage.setQuantity("banana", 100);
        fruitStorage.setQuantity("apple", 200);

        String inputFilePath = "src/main/resources/input.csv";
        String reportFilePath = "src/main/java/core/basesyntax/report.csv";

        CsvFileReader csvFileReader = new CsvFileReader();
        List<FruitTransaction> transactions = csvFileReader.readFromFile(inputFilePath);

        for (FruitTransaction transaction : transactions) {
            fruitStorage.processTransaction(transaction);
        }

        fruitStorage.generateReport();

        new CsvFileWriter().writeToFile(reportFilePath, fruitStorage.getFruitQuantities(), false);
    }
}
