package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_COUNT_INDEX = 2;
    private static final String DATA_SPLIT_SYMBOL = ",";

    @Override
    public List<FruitTransaction> toTransaction(List<String> data) {
        return data.stream()
                .map(transaction -> transaction.toLowerCase().split(DATA_SPLIT_SYMBOL))
                .map(transaction -> new FruitTransaction(
                        getOperationByName(transaction[OPERATION_INDEX]),
                        transaction[FRUIT_TYPE_INDEX],
                        Integer.parseInt(transaction[FRUIT_COUNT_INDEX])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperationByName(String name) {
        for (FruitTransaction.Operation value : FruitTransaction.Operation.values()) {
            if (value.getOperation().equals(name)) {
                return value;
            }
        }
        return null;
    }
}
