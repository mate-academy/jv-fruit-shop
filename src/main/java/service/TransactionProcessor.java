package service;

import java.util.List;
import model.FruitTransaction;
import strategy.Strategy;

public class TransactionProcessor {
    public void transactionFruits(List<FruitTransaction> fruits) {
        for (FruitTransaction fruit : fruits) {
            Strategy strategy = new Strategy();
            OperationHandler operationService = strategy.getOperationValue(fruit.getOperation());
            operationService.handleTransaction(fruit);
        }
    }
}
