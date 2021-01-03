package core.basesyntax.strategy;

import core.basesyntax.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;

public class AddExecutionStrategy implements ExecutionStrategy {
    @Override
    public void execute(Transaction transaction, FruitStorage storage) {
        Fruit fruit = new Fruit(transaction.getFruitName(), transaction.getDate());
        storage.add(fruit, transaction.getQuantity());
    }
}
