package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int FIRST_LINE = 1;
    private static final int OPERATION_PART = 0;
    private static final int NAME_FRUIT_PART = 1;
    private static final int QUANTITY_PART = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        return data.stream()
                .skip(FIRST_LINE)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseTransaction(String line) {
        String[] split = line.split(",");

        for (int i = 0; i < split.length; i++) {
            split[i] = split[i].trim();
        }

        FruitTransaction transaction = new FruitTransaction();
        transaction.setTransaction(
                FruitTransaction.Operation.fromCode(split[OPERATION_PART]),
                split[NAME_FRUIT_PART],
                Integer.parseInt(split[QUANTITY_PART]));
        return transaction;
    }
}
