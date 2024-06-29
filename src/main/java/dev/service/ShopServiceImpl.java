package dev.service;

import dev.repository.Repository;
import dev.service.operation.OperationHandler;
import dev.transaction.FruitTransaction;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions, Repository repository) {
        transactions
                .forEach(fruitTransaction -> {
                    String fruit = fruitTransaction.getFruit();
                    Integer before = repository.selectQuantity(fruit);
                    Integer add = fruitTransaction.getQuantity();
                    OperationHandler operationHandler = operationStrategy
                            .toOperationHandler(fruitTransaction.getOperation());
                    Integer now = operationHandler.update(before, add);
                    repository.updateQuantity(fruit, now);
                });
    }
}
