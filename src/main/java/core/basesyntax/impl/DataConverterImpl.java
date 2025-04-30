package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    public static final String COMMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactionFile) {
        return transactionFile.stream()
                .skip(1)
                .map(l -> l.split(COMMA_SEPARATOR))
                .map(arr -> {
                    if (arr.length != 3) {
                        throw new IllegalArgumentException("Invalid CSV row format: "
                                + Arrays.toString(arr));
                    }
                    return arr;
                })
                .map(fields -> {
                    try {
                        return new FruitTransaction(FruitTransaction.Operation.fromCode(fields[0]),
                                fields[1],
                                Integer.parseInt(fields[2]));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid number format in CSV: "
                                + fields[2]);
                    }
                })
                .toList();
    }
}
