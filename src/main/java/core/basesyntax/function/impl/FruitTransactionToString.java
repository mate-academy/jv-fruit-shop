package core.basesyntax.function.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.function.Function;

public class FruitTransactionToString implements Function<FruitTransaction, String> {
    @Override
    public String apply(FruitTransaction fruitTransaction) {
        StringBuilder sb = new StringBuilder();
        sb.append(fruitTransaction.getOperation().getCode())
                .append(",")
                .append(fruitTransaction.getFruit())
                .append(",")
                .append(fruitTransaction.getQuantity());
        return sb.toString();
    }
}
