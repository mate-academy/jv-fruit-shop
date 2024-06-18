package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return inputReport.stream()
                .map(string -> string.split(","))
                .map(strings -> new FruitTransaction(
                        strings[INDEX_OPERATION],
                        strings[INDEX_FRUIT],
                        strings[INDEX_QUANTITY]))
                .toList();
    }
}
