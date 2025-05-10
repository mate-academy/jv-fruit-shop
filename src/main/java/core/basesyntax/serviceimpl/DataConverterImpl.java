package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
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
        for (String line : report.subList(1, report.size())) {
            String[] parts = line.split(ARRAY_SPLIT_POINT);
            if (parts.length < VALID_ARRAY_LENGTH) {
                throw new RuntimeException("Invalid transaction format: " + line);
            }

            String operationCode = parts[FIRST_SPLIT_PART].trim();
            if (!FruitTransaction.Operation.isValidCode(operationCode)) {
                throw new RuntimeException("Invalid operation code: " + operationCode);
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(operationCode);
            String fruit = parts[SECOND_SPLIT_PART].trim();
            int quantity = Integer.parseInt(parts[THIRD_SPLIT_PART].trim());
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
