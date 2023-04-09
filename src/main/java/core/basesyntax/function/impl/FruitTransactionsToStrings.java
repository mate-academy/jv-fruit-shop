package core.basesyntax.function.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FruitTransactionsToStrings implements Function<List<FruitTransaction>, List<String>> {

    @Override
    public List<String> apply(List<FruitTransaction> fruitTransactionList) {
        FruitTransactionToString fruitTransactionToString = new FruitTransactionToString();
        return fruitTransactionList
                .stream()
                .map(fruitTransactionToString)
                .collect(Collectors.toList());
    }
}
