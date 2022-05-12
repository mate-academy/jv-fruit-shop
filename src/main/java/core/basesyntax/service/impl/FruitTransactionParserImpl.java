package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        lines.stream()
                .filter(Objects::nonNull)
                .map(i -> i.split(","))
                .forEach(i -> fruitTransactions.add(
                        new FruitTransaction(FruitTransaction.Operation
                                .findOperationByLetter(i[OPERATION_INDEX]),
                                new Fruit(i[FRUIT_INDEX]), Integer.parseInt(i[QUANTITY_INDEX]))));
        return fruitTransactions;
    }
}
