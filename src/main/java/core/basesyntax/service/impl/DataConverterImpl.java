package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputData) {
        return inputData.stream()
                .skip(1)
                .map(s -> {
                    String[] parts = s.split(",");
                    String operationCode = parts[0];
                    String fruit = parts[1];
                    int quantity = Integer.parseInt(parts[2]);
                    FruitTransaction.Operation operation = FruitTransaction.Operation
                            .fromCode(operationCode);
                    return new FruitTransaction(operation, fruit, quantity);
                }).collect(Collectors.toList());
    }
}
