package core.basesyntax;

import core.basesyntax.model.Transaction;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class Main {
    private static final BufferedReader consoleReader
            = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        System.out.println("Enter path to source file:");
        CsvFileReader csvFileReader = new LocalCsvFileReader(consoleReader.readLine());
        System.out.println("Enter path to output file:");
        CsvFileWriter csvFileWriter = new LocalCsvFileWriter(consoleReader.readLine());

        FruitStorage fruitStorage = new FruitStorage();
        FruitService service = new FruitService(fruitStorage);
        try {
            List<Transaction> transactions = csvFileReader.readTransactions();
            service.fillFruitStorage(transactions);
            Map<String, Integer> stockBalance = fruitStorage.getStockBalance();
            csvFileWriter.createStockFile(stockBalance);
            System.out.println("File created successfully!");
        } catch (Exception e) {
            System.out.println("An error has occurred " + e.getMessage());
            System.out.println("Program closed.");
        }
    }
}
