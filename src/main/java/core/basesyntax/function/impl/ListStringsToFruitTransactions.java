package core.basesyntax.function.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListStringsToFruitTransactions
        implements Function<List<String>, List<FruitTransaction>> {
    public static final int INDEX_TITLE = 0;

    @Override
    public List<FruitTransaction> apply(List<String> strings) {
        StringToFruitTransaction stringToFruitTransaction = new StringToFruitTransaction();
        strings.remove(INDEX_TITLE);
        List<FruitTransaction> fruitTransactionList = strings.stream()
                .map(stringToFruitTransaction)
                .collect(Collectors.toList());
        return fruitTransactionList;
    }
}
