package core.basesyntax.strategy.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler>
            operationServiceMap = new HashMap<>();

    public OperationStrategyImpl() {
        fillOperationServiceMap();
    }

    @Override
    public OperationHandler getOperation(FruitTransaction.Operation type) {
        return operationServiceMap.get(type);
    }

    private void fillOperationServiceMap() {
        FruitDao fruitDao = new FruitDaoImpl();
        operationServiceMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitDao));
        operationServiceMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitDao));
    }
}
