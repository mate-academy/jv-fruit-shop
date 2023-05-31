package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.Map;

public class OperationStrategy {
    private final ProductDao productDao;
    private final Map<FruitTransaction.Operation, OperationHandler> operationServiceMap;

    public OperationStrategy(ProductDao productDao) {
        this.productDao = productDao;
        this.operationServiceMap = createOperationServiceMap();
    }

    public OperationHandler getOperation(FruitTransaction transaction) {
        return operationServiceMap.get(transaction.getOperation());
    }

    private Map<FruitTransaction.Operation, OperationHandler> createOperationServiceMap() {
        return Map.of(
                FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(productDao),
                FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(productDao),
                FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(productDao),
                FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(productDao));
    }
}
