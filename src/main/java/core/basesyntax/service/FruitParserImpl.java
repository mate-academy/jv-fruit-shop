package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitParserImpl implements FruitParser {
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;
    private FruitStrategy fruitStrategy;

    public FruitParserImpl(FruitDao fruitDao, FruitStrategy fruitStrategy) {
        this.fruitDao = fruitDao;
        this.fruitStrategy = fruitStrategy;
    }

    @Override
    public Map<String, Integer> parse() {
        Map<String, Integer> fruitQuantityMap = new HashMap<>();
        List<String> lines = fruitDao.get();
        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(SEPARATOR);
            String operation = data[0];
            String fruitName = data[1];
            int quantity = Integer.parseInt(data[2]);
            fruitStrategy.applyToStorage(fruitQuantityMap, operation, fruitName, quantity);
        }
        return fruitQuantityMap;
    }
}
