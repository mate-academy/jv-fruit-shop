package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.TransactionParser;
import java.util.List;

public class TransactionProcessor {
    private final OperationStrategy operationStrategy;
    private final TransactionParser transactionParser;

    public TransactionProcessor(OperationStrategy operationStrategy,
                                TransactionParser transactionParser) {
        this.operationStrategy = operationStrategy;
        this.transactionParser = transactionParser;
    }

    public void processTransactions(List<String> inputData) {
        inputData.stream()
                .map(transactionParser::parseLine)
                .forEach(transaction -> {
                    OperationHandler handler = operationStrategy
                            .getHandler(transaction.getOperation());
                    Fruit fruit = new Fruit(transaction.getFruitName());
                    handler.apply(fruit, transaction.getQuantity());
                });
    }
}
