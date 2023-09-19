package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.HandleTransactionStrategy;
import core.basesyntax.service.strategy.HandleTransactionStrategyImpl;
import core.basesyntax.service.strategy.TransactionHandler;
import java.util.List;

public class ProcessInputService {
    public boolean parseInput(List<String> inputList) {
        HandleTransactionStrategy strategy = new HandleTransactionStrategyImpl();
        for (int i = 1; i < inputList.size(); i++) {
            String[] elements = inputList.get(i).split(",");
            String operationCode = elements[0];
            Fruit fruit = new Fruit(elements[1]);
            int quantity = Integer.parseInt(elements[2]);
            FruitTransaction newTransaction = new FruitTransaction(operationCode, fruit, quantity);
            TransactionHandler transactionHandler = strategy.get(newTransaction.getOperation());
            transactionHandler.handleTransaction(newTransaction);
        }
        return true;
    }
}

