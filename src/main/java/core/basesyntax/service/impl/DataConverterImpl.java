package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(",");

                    String operationCode = parts[0].trim();
                    String fruit = parts[1].trim();
                    int quantity = Integer.parseInt(parts[2].trim());

                    FruitTransaction.Operation operation = getOperation(operationCode);

                    FruitTransaction transaction = new FruitTransaction();
                    transaction.setOperation(operation);
                    transaction.setFruit(fruit);
                    transaction.setQuantity(quantity);
                    return transaction;
                })
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperation(String code) {
        for (FruitTransaction.Operation op : FruitTransaction.Operation.values()) {
            if (op.getCode().equals(code)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Unknown operation code: " + code);
    }
}
