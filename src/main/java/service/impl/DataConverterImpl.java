package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final String DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) { // skip header
            transactions.add(parseLine(lines.get(i)));
        }
        return transactions;
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(DELIMITER);
        FruitTransaction.Operation operation =
                FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]);
        String fruit = parts[FRUIT_INDEX];
        int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
