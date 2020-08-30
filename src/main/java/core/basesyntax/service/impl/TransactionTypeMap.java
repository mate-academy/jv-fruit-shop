package core.basesyntax.service.impl;

import java.util.HashMap;
import java.util.Map;

public class TransactionTypeMap {
    public static final Map<Character, StockChangeable> typeMap = new HashMap<>() {{
            put('s', new AddingFruit());
            put('r', new AddingFruit());
            put('b', new SalesFruit());
        }};
}
