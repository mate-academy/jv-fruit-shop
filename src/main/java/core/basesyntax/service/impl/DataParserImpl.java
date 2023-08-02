package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final int AMOUNT_OF_NEEDED_PARTS = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String LINE_SEPARATOR = ",";

    public List<FruitTransaction> parseData(List<String> dataFromFile) {
        return dataFromFile.stream()
                .skip(1)
                .map(this::splitRow)
                .map(values -> new FruitTransaction(
                        FruitTransaction.Operation.getOperation(values[OPERATION_INDEX]),
                        values[PRODUCT_INDEX],
                        Integer.parseInt(values[AMOUNT_INDEX])
                ))
                .collect(Collectors.toList());
    }

    private String[] splitRow(String row) {
        String[] values = row.split(LINE_SEPARATOR);
        if (values.length != AMOUNT_OF_NEEDED_PARTS) {
            throw new IllegalArgumentException("Invalid row format: " + row);
        }
        return values;
    }
}
