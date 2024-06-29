package dev.service;

import dev.repository.Repository;
import dev.service.operation.OperationHandler;
import dev.transaction.FruitTransaction;
import java.util.List;
import java.util.function.Consumer;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions, Repository repository) {
        transactions.stream()
                .forEach(new Consumer<FruitTransaction>() {
                    @Override
                    public void accept(FruitTransaction fruitTransaction) {
                        String fruit = fruitTransaction.getFruit();
                        Integer before = repository.readQuantity(fruit);
                        Integer add = fruitTransaction.getQuantity();
                        OperationHandler operationHandler = operationStrategy
                                .toOperationHandler(fruitTransaction.getOperation());
                        Integer now = operationHandler.update(before, add);
                        repository.updateQuantity(fruit, now);
                    }
                });
    }
}
