package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String COMMA = ",";

    @Override
    public List<FruitTransaction> getTransaction(List<String> transaction) {
        return transaction.stream()
                .skip(1)
                .map(s -> s.split(COMMA))
                .map(t -> new FruitTransaction(t[OPERATION_INDEX],
                        t[FRUIT_NAME_INDEX],
                        Integer.parseInt(t[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }
}
