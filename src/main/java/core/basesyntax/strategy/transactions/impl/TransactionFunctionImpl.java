package core.basesyntax.strategy.transactions.impl;

import core.basesyntax.strategy.transactions.FruitTransaction;
import core.basesyntax.strategy.transactions.TransactionFunction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionFunctionImpl implements TransactionFunction {
    @Override
    public List<FruitTransaction> apply(List<String> strings) {
        return strings.stream()
                .map(FruitTransaction::new)
                .collect(Collectors.toList());
    }
}
