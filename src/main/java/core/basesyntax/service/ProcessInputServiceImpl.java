package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.HandleTransactionStrategy;
import core.basesyntax.service.strategy.HandleTransactionStrategyImpl;
import core.basesyntax.service.strategy.TransactionHandler;
import java.util.List;

public class ProcessInputServiceImpl implements ProcessInputService {

    public static final String SPLITTER = ",";

    public boolean parseInput(List<String> inputList) {
        HandleTransactionStrategy strategy = new HandleTransactionStrategyImpl();
        FruitTransaction fruitTransaction;
        for (int i = 1; i < inputList.size(); i++) {
            fruitTransaction = createTransaction(inputList.get(i));
            TransactionHandler transactionHandler = strategy.get(fruitTransaction.getOperation());
            transactionHandler.handleTransaction(fruitTransaction);
        }
        return true;
    }

    private FruitTransaction createTransaction(String line) {
        String[] elements = line.split(SPLITTER);
        String operationCode = elements[0];
        String fruit = elements[1];
        int quantity = Integer.parseInt(elements[2]);
        return new FruitTransaction(operationCode, fruit, quantity);
    }
}

