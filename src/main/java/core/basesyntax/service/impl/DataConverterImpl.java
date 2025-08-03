package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> result = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String[] parts = data.get(i).split(COMMA_SEPARATOR);
            result.add(
                    new FruitTransaction(
                            parts[FRUIT_INDEX],
                            FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]),
                            Integer.parseInt(parts[QUANTITY_INDEX])
                    )
            );
        }
        return result;
    }
}
