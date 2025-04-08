package core.basesyntax.serviceimpl;

import core.basesyntax.database.FruitStock;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final FruitStock fruitStock;
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(FruitStock fruitStock, OperationStrategy operationStrategy) {
        this.fruitStock = fruitStock;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void addFruit(String fruit, int quantity) {
        fruitStock.add(fruit, quantity);
    }

    @Override
    public int getFruitQuantity(String fruit) {
        return fruitStock.getQuantity(fruit);
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.executeOperation(transaction, fruitStock.getStock());
        }
    }
}
