package core.basesyntax.service.impl;

import java.util.HashMap;
import java.util.Map;

public class TransactionTypeMap {
    public static final Map<Character, StockChangeable> typeMap;

    static {
        typeMap = new HashMap<>();
        typeMap.put('s', new AddingFruit());
        typeMap.put('r', new AddingFruit());
        typeMap.put('b', new SalesFruit());
    }
}
