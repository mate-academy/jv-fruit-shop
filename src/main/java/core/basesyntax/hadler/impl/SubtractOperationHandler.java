package core.basesyntax.hadler.impl;

import static core.basesyntax.enums.Operation.PURCHASE;

import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public class SubtractOperationHandler implements OperationHandler {
    @Override
    public int getAmount(String fruit, List<FruitTransaction> transactions) {
        return transactions.stream()
                .filter(transaction ->
                        transaction.getFruit().equals(fruit)
                                && transaction.getOperation().equals(PURCHASE))
                .map(FruitTransaction::getQuantity)
                .reduce(0, Integer::sum);
    }
}
