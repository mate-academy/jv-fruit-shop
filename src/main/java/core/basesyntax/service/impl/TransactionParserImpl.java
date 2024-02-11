package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private static final int START_TRANSACTION_INDEX = 0;
    private static final int END_TRANSACTION_INDEX = 1;
    private static final int START_FRUIT_NAME_INDEX = 2;
    private List<FruitTransaction> fruitTransactionList;

    @Override
    public List<FruitTransaction> parsOf(List<String> fruits) {
        return fruitTransactionList = fruits.stream()
                .skip(1)
                .map(fruit -> new FruitTransaction(fruit.trim()
                        .substring(START_TRANSACTION_INDEX, END_TRANSACTION_INDEX),
                        fruit.trim().replaceAll("[\\d]", "")
                                .substring(START_FRUIT_NAME_INDEX).replaceAll("[^a-zA-Z]", ""),
                        Integer.parseInt(fruit.trim().replaceAll("[^\\d]", ""))))
                .collect(Collectors.toList());
    }

    @Override
    public List<FruitTransaction> getListFruit() {
        return fruitTransactionList;
    }
}
