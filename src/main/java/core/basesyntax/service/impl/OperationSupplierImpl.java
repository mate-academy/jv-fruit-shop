package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationSupplier;
import core.basesyntax.strategy.BalanceFruitOperation;
import core.basesyntax.strategy.FruitOperation;
import core.basesyntax.strategy.PurchaseFruitOperation;
import core.basesyntax.strategy.ReturnFruitOperation;
import core.basesyntax.strategy.SupplyFruitOperation;
import java.util.HashMap;
import java.util.Map;

public class OperationSupplierImpl implements OperationSupplier {
    private final Map<String, FruitOperation> operationMap;

    public OperationSupplierImpl() {
        operationMap = new HashMap<>();
        operationMap.put("b", new BalanceFruitOperation());
        operationMap.put("s", new SupplyFruitOperation());
        operationMap.put("p", new PurchaseFruitOperation());
        operationMap.put("r", new ReturnFruitOperation());
    }

    @Override
    public FruitOperation getOperation(Fruit fruit) {
        return operationMap.get(fruit.getOperation());
    }
}
