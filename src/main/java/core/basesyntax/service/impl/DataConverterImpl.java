package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> result = data.stream()
                .skip(1)
                .map(l -> {
                    String[] parts = l.split(",");
                    int quantity = Integer.parseInt(parts[2]);
                    FruitTransaction.Operation operation = getOpertation(parts[0]);
                    FruitTransaction fruitTransaction =
                            new FruitTransaction(quantity, parts[1], operation);
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
        return result;
    }

    private FruitTransaction.Operation getOpertation(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }
        throw new RuntimeException();
    }
}
