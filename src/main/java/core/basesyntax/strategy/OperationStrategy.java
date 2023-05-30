package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProductDao;
import core.basesyntax.strategy.impl.BalanceOperationImpl;
import core.basesyntax.strategy.impl.PurchaseOperationImpl;
import core.basesyntax.strategy.impl.ReturnOperationImpl;
import core.basesyntax.strategy.impl.SupplyOperationImpl;
import java.util.Map;

public class OperationStrategy {
    private final ProductDao productDao;
    private final Map<FruitTransaction.Operation, OperationService> operationServiceMap;

    public OperationStrategy(ProductDao productDao) {
        this.productDao = productDao;
        this.operationServiceMap = createOperationServiceMap();
    }

    public OperationService getOperation(FruitTransaction transaction) {
        return operationServiceMap.get(transaction.getOperation());
    }

    private Map<FruitTransaction.Operation, OperationService> createOperationServiceMap() {
        return Map.of(
                FruitTransaction.Operation.BALANCE,
                new BalanceOperationImpl(productDao),
                FruitTransaction.Operation.SUPPLY,
                new SupplyOperationImpl(productDao),
                FruitTransaction.Operation.RETURN,
                new ReturnOperationImpl(productDao),
                FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationImpl(productDao)
        );
    }
}
