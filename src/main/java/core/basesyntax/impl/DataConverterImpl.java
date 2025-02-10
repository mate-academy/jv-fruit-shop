package core.basesyntax.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    public static final String COMMA_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactionFile) {
        return transactionFile.stream()
                .map(l -> l.split(COMMA_SEPARATOR))
                .filter(arr -> arr.length == 3)
                .map(fields -> new FruitTransaction(FruitTransaction.Operation
                        .fromCode(fields[0]), fields[1], Integer.parseInt((fields[2]))))
                .collect(Collectors.toList());
    }
}
