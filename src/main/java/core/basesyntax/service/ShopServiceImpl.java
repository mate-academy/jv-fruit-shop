package core.basesyntax.service;

import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        if(fruitTransactions == null) {
            throw new RuntimeException("fruitTransactions in null");
        }
        fruitTransactions.forEach(f -> operationStrategy
                .getOperationHandler(f.getOperation()).processTransaction(f));
    }
}
