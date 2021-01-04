package core.basesyntax.service;

import core.basesyntax.service.operations.*;

import java.util.HashMap;
import java.util.Map;

public class PrepareMapImpl implements PrepareMap {
    @Override
    public Map<String, Operation> prepareMap() {
        Map<String, Operation> result = new HashMap<>();
        result.put("b", new BalanceOperation());
        result.put("s", new SupplyOperation());
        result.put("p", new PurchaseOperation());
        result.put("r", new ReturnOperation());
        return result;
    }
}
