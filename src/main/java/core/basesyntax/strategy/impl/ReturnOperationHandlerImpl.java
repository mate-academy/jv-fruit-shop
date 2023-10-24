package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.function.Predicate;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public long count(List<FruitTransaction> fruits, String fruitName) {
        Predicate<FruitTransaction> filterByNameAndOperation = f ->
                f.getFruitName().equals(fruitName)
                && f.getOperation() == Operation.RETURN;

        return fruits.stream()
                .filter(filterByNameAndOperation)
                .mapToInt(FruitTransaction::getQuantity)
                .sum();
    }
}
