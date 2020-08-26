package core.basesyntax.strategy;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.Transaction;

public class SubtractionExecutionStrategy implements ExecutionStrategy {
    @Override
    public void execute(Transaction transaction, FruitStorage storage) {
        storage.sell(transaction.getFruitName(),
                transaction.getDate(), transaction.getQuantity());
    }
}
