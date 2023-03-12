package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int FIRST_LINE_POSITION = 0;
    private static final int OPERATION_POSITION = 0;
    private static final int FRUIT_NAME_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private static final String LINES_SPLITERATOR = ",";

    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> data) {
        data.remove(FIRST_LINE_POSITION);
        return data.stream()
                .map(d -> d.split(LINES_SPLITERATOR))
                .map(a -> new FruitTransaction(FruitTransaction.Operation
                                .getOperation(a[OPERATION_POSITION]),
                        new Fruit(a[FRUIT_NAME_POSITION]),
                        Integer.parseInt(a[QUANTITY_POSITION])))
                .collect(Collectors.toList());
    }
}
