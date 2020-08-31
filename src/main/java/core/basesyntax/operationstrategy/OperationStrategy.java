package core.basesyntax.operationstrategy;

import core.basesyntax.fruitservice.Transaction;
import core.basesyntax.operation.BuyOperation;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.ReturnOperation;
import core.basesyntax.operation.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationStrategy {
    private static final Map<String, Operation> operationStrategy = new HashMap<>();

    static {
        operationStrategy.put("s", new SupplyOperation());
        operationStrategy.put("b", new BuyOperation());
        operationStrategy.put("r", new ReturnOperation());
    }

    public void operation(Map<String, Integer> fruitMap, List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            Operation op = operationStrategy.get(transaction.getOperation());
            op.operation(fruitMap, transaction);
        }
    }
}
