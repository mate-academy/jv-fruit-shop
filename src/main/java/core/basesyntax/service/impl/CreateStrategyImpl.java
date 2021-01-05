package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.CreateStrategy;
import core.basesyntax.service.operations.BalanceOperation;
import core.basesyntax.service.operations.Operation;
import core.basesyntax.service.operations.PurchaseOperation;
import core.basesyntax.service.operations.ReturnOperation;
import core.basesyntax.service.operations.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class CreateStrategyImpl implements CreateStrategy {
    @Override
    public Map<String, Operation> createStrategy() {
        Map<String, Operation> result = new HashMap<>();
        result.put("b", new BalanceOperation());
        result.put("s", new SupplyOperation());
        result.put("p", new PurchaseOperation());
        result.put("r", new ReturnOperation());
        return result;
    }
}
