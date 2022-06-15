package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.handlers.OperationHandler;
import core.basesyntax.service.handlers.OperationStrategyImpl;
import java.util.List;

public class LineProcessor {

    public void processLine(List<Transaction> transactionList) {
        for (Transaction transaction: transactionList) {
            Operation operation = transaction.getOperation();
            Fruit fruit = transaction.getFruit();
            Integer quantity = transaction.getQuantity();

            OperationHandler operationHandler = OperationStrategyImpl.getOperationHandlersMap()
                    .get(operation);
            operationHandler.processOperation(operation, fruit, quantity);
        }
    }
}
