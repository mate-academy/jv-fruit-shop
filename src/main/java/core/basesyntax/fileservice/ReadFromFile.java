package core.basesyntax.fileservice;

import core.basesyntax.fruitservice.Transaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
    public List<Transaction> readFromFile(String filename) {
        try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
            String line;
            int forRemoveHeader = 0;
            List<Transaction> transactions = new ArrayList<>();
            while ((line = input.readLine()) != null) {
                if (forRemoveHeader == 0) {
                    forRemoveHeader++;
                    continue;
                }
                String[] strings = line.split(",");
                transactions.add(Transaction.build(strings[0], strings[1],
                        strings[2], strings[3]));
            }
            return transactions;
        } catch (IOException e) {
            throw new RuntimeException("Problem with reading files", e);
        }
    }
}
