package core.basesyntax.services.shopService;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.strategies.IOperationStrategy;

import java.util.List;

public class ShopService implements IShopService {
    private final IOperationStrategy operationStrategy;

    public ShopService(IOperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            operationStrategy.get(transaction.operation()).handleOperation(transaction.fruit(), transaction.quantity());
        }
    }
}
