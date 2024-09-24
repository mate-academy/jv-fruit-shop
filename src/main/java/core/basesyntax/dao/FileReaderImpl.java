package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private static final String INPUT_DATA = "fruit_shop_transactions.csv";

    @Override
    public List<FruitTransaction> readFile(String fileName) {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                OperationType operation = OperationType.fromCode(data[0]);
                String fruit = data[1];
                int quantity = Integer.parseInt(data[2]);

                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file " + fileName, e);
        }
        return transactions;
    }
}
