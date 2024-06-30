package dev.service;

import dev.repository.FruitStore;
import dev.service.operation.OperationHandler;
import dev.transaction.FruitTransaction;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions, FruitStore repository) {
        transactions
                .forEach(fruitTransaction -> {
                    String fruit = fruitTransaction.getFruit();
                    Integer add = fruitTransaction.getQuantity();
                    OperationHandler operationHandler = operationStrategy
                            .toOperationHandler(fruitTransaction.getOperation());
                    operationHandler.update(repository, fruit, add);
                });
    }
}
