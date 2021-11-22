package core.basesyntax.db;

import core.basesyntax.model.Fruit;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Storage {
    public static final Map<Fruit.Type, BigDecimal> storage = new HashMap();
}
