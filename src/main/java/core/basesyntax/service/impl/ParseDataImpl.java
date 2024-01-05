package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseData;
import java.util.List;
import java.util.stream.Collectors;

public class ParseDataImpl implements ParseData {
    private static final String SEPARATOR = ",";
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;

    @Override
    public List<FruitTransaction> parser(List<String> fruitsData) {
        return fruitsData
                .stream()
                .map(row -> row.split(SEPARATOR))
                .filter(data -> data[INDEX_ZERO].trim().length() == 1)
                .map(data ->
                        new FruitTransaction(FruitTransaction.Operation
                                .getOperation(data[INDEX_ZERO].trim()), data[INDEX_ONE],
                                Integer.parseInt(data[INDEX_TWO])))
                .collect(Collectors.toList());
    }
}
