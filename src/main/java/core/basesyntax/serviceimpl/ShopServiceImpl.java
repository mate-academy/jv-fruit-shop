package core.basesyntax.serviceimpl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.OperationHandler;
import core.basesyntax.OperationStrategy;
import core.basesyntax.ShopService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            handler.apply(transaction);
        }
    }
}
