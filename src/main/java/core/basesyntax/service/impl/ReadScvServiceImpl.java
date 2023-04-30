package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReadScvService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadScvServiceImpl implements ReadScvService {
    private static final int OPERATION_COLUMN_INDEX = 0;
    private static final int FRUIT_COLUMN_INDEX = 1;
    private static final int QUANTITY_COLUMN_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> readFromFile(String filePath) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                FruitTransaction fruitTransaction = new FruitTransaction();
                String[] value = line.split((SEPARATOR));
                fruitTransaction.setOperation(FruitTransaction
                        .Operation.fromCode(value[OPERATION_COLUMN_INDEX]));
                fruitTransaction.setFruit(value[FRUIT_COLUMN_INDEX]);
                fruitTransaction.setQuantity(Integer.parseInt(value[QUANTITY_COLUMN_INDEX]));
                fruitTransactions.add(fruitTransaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + filePath, e);
        }
        return fruitTransactions;
    }
}
