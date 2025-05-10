package core.basesyntax.shopservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationhandler.OperationStrategy;
import core.basesyntax.operationhandler.operation.OperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            String fruit = transaction.getFruit();
            int quantity = transaction.getQuantity();
            FruitTransaction.Operation operation = transaction.getOperation();

            OperationHandler handler = strategy.getOperation(operation);
            handler.handleOperation(fruit, quantity);
        }
    }
}
