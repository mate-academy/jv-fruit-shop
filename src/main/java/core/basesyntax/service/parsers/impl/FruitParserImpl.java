package core.basesyntax.service.parsers.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.parsers.FruitParser;
import java.util.HashMap;
import java.util.Map;

public class FruitParserImpl implements FruitParser {
    private Map<String, Fruit> fruitMap;

    public FruitParserImpl() {
        fruitMap = new HashMap<>();
        fruitMap.put("banana", Fruit.BANANA);
        fruitMap.put("apple", Fruit.APPLE);
    }

    @Override
    public Fruit parse(String fruitName) {
        return fruitMap.get(fruitName);
    }
}
