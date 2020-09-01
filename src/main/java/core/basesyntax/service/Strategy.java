package core.basesyntax.service;

import core.basesyntax.impl.ReturnOperation;
import core.basesyntax.impl.SellOperation;
import core.basesyntax.impl.SupplyOperation;
import core.basesyntax.model.FruitBox;
import java.util.HashMap;
import java.util.Map;

public class Strategy {
    private static final String SUPPLIER = "s";
    private static final String CONSUMER = "b";
    private static final String RETURNER = "r";
    private final Map<String, Operator<FruitBox>> operations = new HashMap<>();

    public Strategy() {
        operations.put(SUPPLIER, new SupplyOperation());
        operations.put(CONSUMER, new SellOperation());
        operations.put(RETURNER, new ReturnOperation());
    }

    public Operator<FruitBox> getOperator(String option) {
        return option.equals("s") ? operations.get(SUPPLIER)
                : option.equals("b") ? operations.get(CONSUMER)
                : operations.get(RETURNER);
    }
}
