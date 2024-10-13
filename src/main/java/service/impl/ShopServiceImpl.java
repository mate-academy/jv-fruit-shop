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

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> toStorage = fruitTransactions.stream()
                .collect(Collectors.toMap(
                        FruitTransaction::getFruit,
                        this::getQuantityOfTransaction,
                        Integer::sum
                ));
        checkBalance(toStorage);
        Storage.updateDataBase(toStorage);
    }

    private int getQuantityOfTransaction(FruitTransaction transaction) {
        return operationStrategy.getOperationHandler(transaction.getOperation())
                .getQuantityToCalculate(transaction);
    }

    private void checkBalance(Map<String, Integer> transactions) {
        boolean isNegative = transactions.entrySet().stream()
                .anyMatch(entry -> entry.getValue() < 0);
        if (isNegative) {
            throw new RuntimeException("Balance is negative");
        }
    }
}
