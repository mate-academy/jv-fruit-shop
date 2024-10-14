package service.impl;

import database.StorageDealer;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ShopService;
import strategy.OperationStrategy;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final StorageDealer storageDealer;

    public ShopServiceImpl(OperationStrategy operationStrategy, StorageDealer storageDealer) {
        this.operationStrategy = operationStrategy;
        this.storageDealer = storageDealer;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> toStorage = fruitTransactions.stream()
                .collect(Collectors.toMap(
                        FruitTransaction::getFruit,
                        this::getQuantityOfTransaction,
                        Integer::sum
                ));
        storageDealer.checkBalance(toStorage);
        storageDealer.updateDatabase(toStorage);
    }

    private int getQuantityOfTransaction(FruitTransaction transaction) {
        return operationStrategy.getOperationHandler(transaction.getOperation())
                .getQuantityToCalculate(transaction);
    }
}
