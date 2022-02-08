package core.basesyntax.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitParserImpl implements FruitParser {
    public static final String SEPARATOR = ",";
    private FruitStrategy fruitStrategy;

    public FruitParserImpl(FruitStrategy fruitStrategy) {
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public Map<String, Integer> parse(List<String> input) {
        Map<String, Integer> fruitQuantityMap = new HashMap<>();
        for (int i = 1; i < input.size(); i++) {
            String[] data = input.get(i).split(SEPARATOR);
            String operation = data[0];
            String fruitName = data[1];
            int quantity = Integer.parseInt(data[2]);
            fruitStrategy.applyToStorage(fruitQuantityMap, operation, fruitName, quantity);
        }
        return fruitQuantityMap;
    }
}
