package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.StringListProcessor;
import core.basesyntax.service.handlers.OperationHandler;
import core.basesyntax.service.handlers.OperationStrategyImpl;
import java.util.List;

public class StringListProcessorImpl implements StringListProcessor {
    @Override
    public void stringListToFruitIntegerMap(List<String> fileContent) {
        for (String line : fileContent) {
            String[] values = line.split(",");
            Transaction transaction = new Transaction(Transaction.Operation.getOperation(values[0]),
                                                        new Fruit(values[1]),
                                                        Integer.valueOf(values[2]));

            OperationStrategyImpl operationStrategy = new OperationStrategyImpl();
            OperationHandler operationHandler = operationStrategy.get(transaction
                                                                        .getAbbreviature());
            operationHandler.processOperation(transaction.getAbbreviature(),
                                                transaction.getFruit(),
                                                transaction.getQuantity());
        }
    }
}
