package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.operations.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionProcessor {
    private final Map<Operation, OperationHandler> operations;

    public TransactionProcessor(HashMap<Operation, OperationHandler> operations) {
        this.operations = operations;
    }

    public void processTransactions(List<FruitTransaction> transactions) {
        transactions
                .forEach(e -> operations.get(e.operation()).processOperation(e));
    }
}
