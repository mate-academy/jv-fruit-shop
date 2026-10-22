package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Optional;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final FruitStorage fruitStorage;

    public ShopServiceImpl(OperationStrategy operationStrategy, FruitStorage fruitStorage) {
        this.operationStrategy = operationStrategy;
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction fruitTransaction: fruitTransactions) {
            Optional<Fruit> optionalFruit = fruitStorage.get(fruitTransaction.getFruitName());

            int storageQuantity = optionalFruit.isPresent() ? optionalFruit.get().getQuantity() : 0;

            int newQuantity = operationStrategy.getOperationHandler(fruitTransaction.getOperation())
                    .updateQuantity(storageQuantity, fruitTransaction.getQuantity());

            if (newQuantity < 0) {
                throw new RuntimeException("Balance cannot be negative");
            }

            fruitStorage.update(fruitTransaction.getFruitName(), newQuantity);
        }
    }
}
