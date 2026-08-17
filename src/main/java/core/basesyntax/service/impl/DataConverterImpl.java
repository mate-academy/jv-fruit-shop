package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        List<FruitTransaction> transactions = new ArrayList<>();

        if (inputReport == null || inputReport.isEmpty()) {
            throw new RuntimeException(
                    "Input report can't be null or empty"
            );
        }
        for (int i = 1; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            if (line == null || line.isBlank()) {
                throw new RuntimeException(
                        "Invalid empty line at index: " + i
                );
            }
            String[] data = line.split(",");
            if (data.length != 3) {
                throw new RuntimeException(
                        "Invalid transaction format: " + line
                );
            }
            String operationCode = data[0].trim();
            String fruit = data[1].trim();
            String quantityValue = data[2].trim();
            int quantity;

            try {
                quantity = Integer.parseInt(data[2].trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException(
                        "Invalid quantity: " + data[2],
                        e
                );
            }
            if (quantity < 0) {
                throw new RuntimeException(
                        "Quantity can't be negative: " + quantity
                );
            }
            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getOperationByCode(operationCode);
            FruitTransaction transaction = new FruitTransaction(
                    operation,
                    fruit,
                    quantity
            );
            transactions.add(transaction);
        }
        return transactions;
    }
}
