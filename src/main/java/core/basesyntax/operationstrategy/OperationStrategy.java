package core.basesyntax.operationstrategy;

import core.basesyntax.fruitservice.Transaction;
import core.basesyntax.operation.Buy;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.Return;
import core.basesyntax.operation.Supply;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperationStrategy {
    private static final Map<String, Operation> operationStrategy = new HashMap<>();

    static {
        operationStrategy.put("s", new Supply());
        operationStrategy.put("b", new Buy());
        operationStrategy.put("r", new Return());
    }

    public void operation(Map<String,Integer> fruitDao, List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            Operation op = operationStrategy.get(transaction.getOperation());
            op.operation(fruitDao, transaction);
        }
    }
}
