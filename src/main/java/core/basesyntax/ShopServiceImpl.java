package core.basesyntax;

import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            OperationHandler handler = operationStrategy
                    .getOperationHandler(transaction.getOperation());
            handler.handle(transaction);
        }
    }
}
