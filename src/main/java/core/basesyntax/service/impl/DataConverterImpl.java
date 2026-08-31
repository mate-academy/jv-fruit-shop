package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < inputReport.size(); i++) {
            String[] parts = inputReport.get(i).split(",");

            String operationCode = parts[0].trim();
            String fruit = parts[1].trim();
            int quantity = Integer.parseInt(parts[2].trim());

            FruitTransaction.Operation operation = getOperation(operationCode);
            transactions.add(
                    new FruitTransaction(operation, fruit, quantity)
            );
        }
        return transactions;
    }

    private FruitTransaction.Operation getOperation(String operationCode) {
        for (FruitTransaction.Operation operation
                : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(operationCode)) {
                return operation;
            }
        }

        throw new RuntimeException(
                "Unknown operation code: " + operationCode
        );
    }
}
