package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FormatTransformerService;
import java.util.List;
import java.util.stream.Collectors;

public class FormatTransformerServiceImpl implements FormatTransformerService {
    private static final String LINE_SEPARATOR = ",";
    private static final int LENGTH_LINE = 3;
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> formatData(List<String> data) {
        return data.stream()
                .map(line -> line.split(LINE_SEPARATOR))
                .filter(values -> values.length == LENGTH_LINE)
                .map(values -> {
                    String operation = values[INDEX_OF_OPERATION].trim();
                    FruitTransaction.Operation operation1 = FruitTransaction.Operation
                            .getByCode(operation);
                    String fruit = values[INDEX_OF_FRUIT].trim();
                    int quantity = Integer.parseInt(values[INDEX_OF_QUANTITY].trim());
                    return new FruitTransaction(operation1, fruit, quantity);
                })
                .collect(Collectors.toList());
    }
}

