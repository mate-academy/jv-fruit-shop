package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.impl.BalanceOperationServiceImpl;
import core.basesyntax.strategy.impl.PurchaseOperationServiceImpl;
import core.basesyntax.strategy.impl.ReturnOperationServiceImpl;
import core.basesyntax.strategy.impl.SupplyOperationServiceImpl;
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
                new BalanceOperationServiceImpl(productDao),
                FruitTransaction.Operation.SUPPLY,
                new SupplyOperationServiceImpl(productDao),
                FruitTransaction.Operation.RETURN,
                new ReturnOperationServiceImpl(productDao),
                FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationServiceImpl(productDao)
        );
    }
}
