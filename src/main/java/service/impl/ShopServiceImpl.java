package service.impl;

import database.Storage;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public OperationStrategy getOperationStrategy() {
        return operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> toStorage = fruitTransactions.stream()
                .collect(Collectors.toMap(
                        FruitTransaction::getFruit,
                        fruitTransaction -> operationStrategy.getOperationHandler(
                                fruitTransaction.getOperation())
                                .getQuantityToAdd(fruitTransaction),
                        Integer::sum
                ));
        checkBalance(toStorage);
        storageUpdate(toStorage);
    }

    private void storageUpdate(Map<String, Integer> transactions) {
        Storage.getAssortment().putAll(transactions);
    }

    private void checkBalance(Map<String, Integer> transactions) {
        boolean isNotPositive = transactions.entrySet().stream()
                .allMatch(entry -> entry.getValue() <= 0);
        if (isNotPositive) {
            throw new RuntimeException("Balance is not positive");
        }
    }
}
