package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private ProductDao productDao;

    private Map<FruitTransaction.Operation, OperationHandler> strategies
            = Map.of(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(productDao),
            FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(productDao),
            FruitTransaction.Operation.RETURN, new ReturnOperationHandler(productDao),
            FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(productDao));

    public OperationStrategyImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return strategies.get(operation);
    }
}
