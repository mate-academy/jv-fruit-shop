package core.basesyntax;

import java.util.HashMap;
import java.util.Map;

public class OperationType {
    public static final Map<Character, FruitOperation> operationMap = new HashMap<>() {{
            put('s', new SupplyFruitOperation());
            put('r', new SupplyFruitOperation());
            put('b', new BuyFruitOperation());
        }};
}
