package core.basesyntax.shopservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy = new OperationStrategyImpl();

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getHandler(transaction.getOperation()).apply(transaction);
        }

    }
}
