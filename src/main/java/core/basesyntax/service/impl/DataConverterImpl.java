package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> importedData) {
        return importedData.stream()
                .skip(1)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(",");
        String operationCode = parts[0].trim();
        String fruit = parts[1].trim();
        int quantity = Integer.parseInt(parts[2].trim());
        FruitTransaction.Operation operation = null;
        for (FruitTransaction.Operation op : FruitTransaction.Operation.values()) {
            if (op.getCode().equals(operationCode)) {
                operation = op;
                break;
            }
        }
        if (operation == null) {
            throw new RuntimeException("Unknown operation code: " + operationCode);
        }
        return new FruitTransaction(operation, fruit,quantity);
    }
}
