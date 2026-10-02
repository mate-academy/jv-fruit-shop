package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Optional;

public class ShopServiceImpl implements ShopService {
    private final FruitDao fruitDao;
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(FruitDao fruitDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            String name = transaction.getFruit();
            int quantity = transaction.getQuantity();

            Optional<Fruit> existingFruit = fruitDao.getByName(name);

            if ((operation == FruitTransaction.Operation.BALANCE
                    || operation == FruitTransaction.Operation.SUPPLY)
                    && existingFruit.isEmpty()) {
                fruitDao.add(new Fruit(name, quantity));
                continue;
            }

            if ((operation == FruitTransaction.Operation.RETURN
                    || operation == FruitTransaction.Operation.PURCHASE)
                    && existingFruit.isEmpty()) {
                throw new RuntimeException("Fruit not found in store: " + name);
            }

            Fruit fruit = existingFruit.get();
            OperationHandler handler = operationStrategy.get(operation);
            handler.apply(fruit, quantity);
        }
    }
}
