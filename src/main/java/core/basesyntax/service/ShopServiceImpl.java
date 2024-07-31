package core.basesyntax.service;

import core.basesyntax.domain.FruitTransaction;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction currentFruitTransaction : fruitTransactions) {
            FruitTransaction.Operation currentOperation = currentFruitTransaction.getOperation();
            FruitTransaction.FruitName currentFruitName = currentFruitTransaction.getName();
            int currentQuantity = currentFruitTransaction.getQuantity();
            operationStrategy.get(currentOperation)
                    .calculateQuantity(currentFruitName, currentQuantity);
        }
    }
}
