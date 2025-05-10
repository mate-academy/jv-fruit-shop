package core.basesyntax.shopservice;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.handler.OperationHandler;
import core.basesyntax.operation.operationstrategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
