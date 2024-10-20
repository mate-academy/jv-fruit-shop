package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionDaoImpl implements FruitTransactionDao {
    private static final String COMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> readTransaction(String filename) {
        List<FruitTransaction> transactions = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(COMA_SEPARATOR);
                Operation operation = Operation.valueOf(values[0].toUpperCase());
                String fruit = values[1];
                int quantity = Integer.parseInt(values[2]);
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transactions;
    }

    @Override
    public void writeReport(String filename, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
