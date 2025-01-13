package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .skip(1)
                .map(d -> {
                    String[] fields = d.split(",");
                    Operation operation = Operation.fromCode(fields[0].trim());
                    String fruit = fields[1];
                    int quantity = Integer.parseInt(fields[2]);
                    return new FruitTransaction(operation, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}
