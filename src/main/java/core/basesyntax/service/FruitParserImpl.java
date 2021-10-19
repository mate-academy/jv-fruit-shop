package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitOperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitParserImpl implements FruitParser {
    private static final String SEPARATOR = ",";
    private FruitDao fruitDao;
    private Map<String, FruitOperation.Operation> fruitOperationMap;

    public FruitParserImpl(FruitDao fruitDao, Map<String,
            FruitOperation.Operation> fruitOperationMap) {
        this.fruitDao = fruitDao;
        this.fruitOperationMap = fruitOperationMap;
    }

    @Override
    public Map<String, Integer> parse() {
        Map<String, Integer> fruitQuantityMap = new HashMap<>();
        List<String> lines = fruitDao.get();
        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(SEPARATOR);

        }
    }
}
