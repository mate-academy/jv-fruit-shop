package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int EXPECTED_PARTS_COUNT = 3;
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseFromString(List<String> transactionLine) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String transaction : transactionLine) {
            String[] parts = transaction.split(",");
            if (parts.length != EXPECTED_PARTS_COUNT) {
                throw new IllegalArgumentException("Invalid transaction format: "
                        + transactionLine);
            }
            FruitTransaction.Operation operationType =
                    FruitTransaction.Operation.getByCode(parts[OPERATION_TYPE_INDEX]);
            String fruit = parts[FRUIT_NAME_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            parsedData.add(new FruitTransaction(operationType, fruit, quantity));
        }
        return parsedData;
    }
}

