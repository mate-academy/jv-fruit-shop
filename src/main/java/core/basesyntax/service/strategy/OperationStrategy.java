package core.basesyntax.service.strategy;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.PursheOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationServiceMap
            = new HashMap<>();

    public OperationStrategy(ProductDao productDao) {
        operationServiceMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(productDao));
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(productDao));
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PursheOperationHandler(productDao));
        operationServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(productDao));
    }

    public OperationHandler getOperation(FruitTransaction fruitTransaction) {
        return operationServiceMap.get(fruitTransaction.getOperation());
    }
}
