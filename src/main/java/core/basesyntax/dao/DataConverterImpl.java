package core.basesyntax.dao;

import core.basesyntax.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String ARRAY_SPLIT_POINT = ",";
    private static final int VALID_ARRAY_LENGTH = 3;
    private static final int FIRST_SPLIT_PART = 0;
    private static final int SECOND_SPLIT_PART = 1;
    private static final int THIRD_SPLIT_PART = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> report) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : report.subList(0, report.size())) {
            String[] parts = line.split(ARRAY_SPLIT_POINT);
            if (parts.length < VALID_ARRAY_LENGTH) {
                throw new RuntimeException("Invalid transaction format: " + line);
            }

            String operationCode = parts[FIRST_SPLIT_PART];
            if (!FruitTransaction.Operation.isValidCode(operationCode)) {
                throw new RuntimeException("Invalid operation code: " + operationCode);
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation.valueOf(parts[0]);
            String fruit = parts[SECOND_SPLIT_PART];
            int quantity = Integer.parseInt(parts[THIRD_SPLIT_PART]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
