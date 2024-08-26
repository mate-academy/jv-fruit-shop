package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvStorageDaoImpl implements StorageDao {
    private static final int OPERATION = 0;
    private static final int FRUIT_NAME = 1;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> readTransactions(String filePath) {
        List<FruitTransaction> transactionsList = new ArrayList<>();
        try (BufferedReader transactionReader = new BufferedReader(new FileReader(filePath))) {
            String header = transactionReader.readLine();
            String currentLine;
            while ((currentLine = transactionReader.readLine()) != null) {
                String[] currentOperation = currentLine.split(",");
                FruitTransaction.Operation operation =
                        FruitTransaction.Operation.fromCode(currentOperation[OPERATION]);
                FruitTransaction fruitTransaction = new FruitTransaction(operation,
                        currentOperation[FRUIT_NAME],
                        Integer.parseInt(currentOperation[QUANTITY]));
                transactionsList.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return transactionsList;
    }
}
