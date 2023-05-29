package core.basesyntax.strategy;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategy {
    private final ProductDao productDao;
    private final Map<FruitTransaction.Operation, OperationHandler> operationServiceMap;

    public OperationStrategy(ProductDao productDao) {
        this.productDao = productDao;
        this.operationServiceMap = createOperationMap();
    }

    public OperationHandler getOperation(FruitTransaction fruitTransaction) {
        return operationServiceMap.get(fruitTransaction.getOperation());
    }

    private Map<FruitTransaction.Operation, OperationHandler> createOperationMap() {
        return Map.of(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(productDao),
                FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(productDao),
                FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(productDao),
                FruitTransaction.Operation.PURCHASE,
                new PursheOperationHandler(productDao));
    }
}
