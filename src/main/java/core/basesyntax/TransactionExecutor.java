package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.AddExecutionStrategy;
import core.basesyntax.strategy.ExecutionStrategy;
import core.basesyntax.strategy.SubtractionExecutionStrategy;
import java.util.HashMap;
import java.util.Map;

public class TransactionExecutor {
    private static final Map<Operation, ExecutionStrategy> strategies = new HashMap<>();
    private FruitStorage fruitStorage;

    static {
        ExecutionStrategy addStrategy = new AddExecutionStrategy();
        ExecutionStrategy subStrategy = new SubtractionExecutionStrategy();
        strategies.put(Operation.BUY, subStrategy);
        strategies.put(Operation.RETURN, addStrategy);
        strategies.put(Operation.SUPPLY, addStrategy);
    }

    public TransactionExecutor(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    public void execute(Transaction transaction) {
        ExecutionStrategy strategy = strategies.get(transaction.getOperation());
        strategy.execute(transaction, fruitStorage);
    }
}
