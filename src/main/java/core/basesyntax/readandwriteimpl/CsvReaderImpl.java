package core.basesyntax.readandwriteimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.readandwritefile.CsvReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderImpl implements CsvReader {
    private String csvFile = "filename.csv";

    @Override
    public List<FruitTransaction> readDataFromDataBase() {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                FruitTransaction transaction = new FruitTransaction();
                transaction.setOperation(FruitTransaction.Operation.valueOf(parts[0]));
                transaction.setFruit(parts[1]);
                transaction.setQuantity(Integer.parseInt(parts[2]));
                transactions.add(transaction);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return transactions;
    }
}
