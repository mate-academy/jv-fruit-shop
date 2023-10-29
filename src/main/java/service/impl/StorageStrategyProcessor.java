package service.impl;

import db.Storage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.StrategyProcessor;
import strategy.OperationBalance;
import strategy.OperationPurchase;
import strategy.OperationReturn;
import strategy.OperationStrategy;
import strategy.OperationSupply;

public class StorageStrategyProcessor implements StrategyProcessor {

    private final Storage storage;
    private final Map<FruitTransaction.Operation, OperationStrategy> operationStrategyMap;

    public StorageStrategyProcessor(Storage storage) {
        this.storage = storage;
        operationStrategyMap = new HashMap<>();
        operationStrategyMap.put(
                FruitTransaction.Operation.BALANCE, new OperationBalance(storage));
        operationStrategyMap.put(
                FruitTransaction.Operation.PURCHASE, new OperationPurchase(storage));
        operationStrategyMap.put(
                FruitTransaction.Operation.RETURN, new OperationReturn(storage));
        operationStrategyMap.put(
                FruitTransaction.Operation.SUPPLY, new OperationSupply(storage));
    }

    @Override
    public void processTransactionStrategies(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            operationStrategyMap.get(transaction.getOperation()).handleOperation(transaction);
        }
    }
}
