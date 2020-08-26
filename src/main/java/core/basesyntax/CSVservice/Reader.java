package core.basesyntax.CSVservice;

import core.basesyntax.Transaction;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<Transaction> read(String fileName) {
        CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        List<Transaction> transactions = new ArrayList<>();
        try (CSVParser parser = new CSVParser(new FileReader(fileName), format)) {
            for (CSVRecord record : parser) {
                Transaction transaction = new Transaction();
                transaction.setOperation(record.get("type"));
                transaction.setFruitItem(record.get("fruit"));
                transaction.setQuantity(record.get("quantity"));
                transaction.setDate(record.get("date"));
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.out.println("Something went wrong with reading file");
        }
        return transactions;
    }
}
