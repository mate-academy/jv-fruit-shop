package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    @Override
    public List<FruitTransaction> convertToTransaction(List<String> input) {
        return input.stream().skip(1).map(line -> Arrays.stream(line.split(","))
                                               .map(String::trim)
                                               .toList())
                .map(fruitTransaction -> new FruitTransaction(FruitTransaction
                                .Operation.fromCode(fruitTransaction.get(0)),
                        fruitTransaction.get(1), Integer.parseInt(fruitTransaction.get(2))
                )).toList();
    }
}
