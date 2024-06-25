package core.basesyntax.service;

import core.basesyntax.transaction.FruitTransaction;
import core.basesyntax.transaction.Operation;
import core.basesyntax.transaction.OperationHandler;
import core.basesyntax.transaction.OperationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private Map<String, Integer> repository;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        repository = new HashMap<>();
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        fruitTransactions.stream()
                .forEach(new Consumer<FruitTransaction>() {
                    @Override
                    public void accept(FruitTransaction fruitTransaction) {
                        String fruitkey = fruitTransaction.getFruit();
                        OperationHandler operationHandler = operationStrategy
                                .getOperationHandler(fruitTransaction.getOperation())
                                .getValue();
                        repository.putIfAbsent(fruitkey, 0);
                        int quantity = fruitTransaction.getQuantity();
                        Map.Entry<String, Integer> fruitQuantity = repository.entrySet().stream()
                                .filter(entry -> entry.getKey().equals(fruitkey))
                                .reduce((first, second) -> first)
                                .orElseThrow();
                        operationHandler.execute(fruitQuantity, quantity);
                    }
                });

    }
}
