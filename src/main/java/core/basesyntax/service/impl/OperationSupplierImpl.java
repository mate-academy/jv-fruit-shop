package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.OperationSupplier;
import core.basesyntax.strategy.BalanceFruitOperationHandler;
import core.basesyntax.strategy.FruitOperationHandler;
import core.basesyntax.strategy.PurchaseFruitOperationHandler;
import core.basesyntax.strategy.ReturnFruitOperationHandler;
import core.basesyntax.strategy.SupplyFruitOperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationSupplierImpl implements OperationSupplier {
    private Map<String, FruitOperationHandler> map;

    public OperationSupplierImpl() {
        map = new HashMap<>();
        map.put("b", new BalanceFruitOperationHandler());
        map.put("s", new SupplyFruitOperationHandler());
        map.put("r", new ReturnFruitOperationHandler());
        map.put("p", new PurchaseFruitOperationHandler());
    }

    public FruitOperationHandler getOperation(Fruit fruitInput) {
        return map.get(fruitInput.getOperation());
    }
}
