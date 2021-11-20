package core.basesyntax.parsers.impl;

import core.basesyntax.model.Apples;
import core.basesyntax.model.Bananas;
import core.basesyntax.model.Fruits;
import core.basesyntax.parsers.FruitParser;

import java.util.HashMap;
import java.util.Map;

public class FruitParserImpl implements FruitParser {
    private Map<String , Fruits> fruitMap;
    public FruitParserImpl() {
        fruitMap = new HashMap<>();
        fruitMap.put("banana", new Bananas());
        fruitMap.put("apple", new Apples());
    }

    @Override
    public Fruits getFruitService(String fruitName, int quantity) {
        Fruits fruits = fruitMap.get(fruitName);
        fruits.setQuantity(quantity);
        return fruits;
    }
}
