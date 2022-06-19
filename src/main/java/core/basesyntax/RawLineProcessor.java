package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.handlers.OperationHandler;
import core.basesyntax.service.handlers.OperationStrategyImpl;

public class RawLineProcessor {
    public void fileToMap(String csvString) {
        for (String csvLine: csvString.split("\n")) {
            if (csvLine.equals("null")) {
                continue;
            }
            Transaction transaction = new Transaction(csvLine);
            Operation operation = transaction.getOperation();
            Fruit fruit = transaction.getFruit();
            Integer quantity = transaction.getQuantity();

            OperationHandler operationHandler = OperationStrategyImpl.getOperationHandlersMap()
                    .get(operation);
            operationHandler.processOperation(operation, fruit, quantity);
            }
        }
    }