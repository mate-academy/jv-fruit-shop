package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.handlers.OperationHandler;
import core.basesyntax.service.handlers.OperationStrategyImpl;

public class TransactionProcessorImpl implements TransactionProcessor{
        public void fileToMap(String csvString) {
            for (String csvLine: csvString.split("\n")) {
                if (csvLine.equals("null")) {
                    continue;
                }
                TransactionParserImpl parserService = new TransactionParserImpl();
                Transaction transaction = new Transaction(parserService.getOperation(csvLine),
                                                            parserService.getFruit(csvLine),
                                                            parserService.getQuantity(csvLine));
                Transaction.Operation operation = transaction.getAbbreviature();
                Fruit fruit = transaction.getFruit();
                Integer quantity = transaction.getQuantity();

                OperationStrategyImpl operationStrategy = new OperationStrategyImpl();
                OperationHandler operationHandler = operationStrategy.get(operation);
                operationHandler.processOperation(operation, fruit, quantity);
            }
        }
    }