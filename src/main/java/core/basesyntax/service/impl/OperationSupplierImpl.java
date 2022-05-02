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
    public FruitOperation getOperation(Fruit fruitInput) {
        Map<String, FruitOperation> map = new HashMap<>();
        map.put("b", new BalanceFruitOperation());
        map.put("s", new SupplyFruitOperation());
        map.put("r", new ReturnFruitOperation());
        map.put("p", new PurchaseFruitOperation());
        return map.get(fruitInput.getOperation());
    }
}
