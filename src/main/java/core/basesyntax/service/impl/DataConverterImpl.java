package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String DELIMITER = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputList) {
        if (inputList == null) {
            throw new RuntimeException("Input list is null");
        }
        return inputList.stream()
                .skip(1)
                .map(s -> {
                    String[] parts = s.split(DELIMITER);
                    return new FruitTransaction(
                            FruitTransaction.Operation.getFromCode(parts[OPERATION_INDEX]),
                            parts[FRUIT_INDEX],
                            Integer.parseInt(parts[QUANTITY_INDEX])
                    );
                })
                .toList();
    }
}
