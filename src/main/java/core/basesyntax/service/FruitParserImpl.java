package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitParserImpl implements FruitParser {
    private FruitDao fruitDao;
    private Map<String, FruitOperation.Operation> fruitOperationMap;

    public FruitParserImpl(FruitDao fruitDao, Map<String,
            FruitOperation.Operation> fruitOperationMap) {
        this.fruitDao = fruitDao;
        this.fruitOperationMap = fruitOperationMap;
    }

    @Override
    public List<FruitOperation> parse() {
        List<FruitOperation> fruitOperations = new ArrayList<>();
        List<String> lines = fruitDao.get();
        for (int i = 1; i < lines.size(); i++) {
            String[] lineParameters = lines.get(i).split(",");
            if (lineParameters.length != 3 ) {
                throw new RuntimeException("Invalid file content"
                        + System.lineSeparator()
                        + lines.get(i));
            }
            fruitOperations.add(new FruitOperation(fruitOperationMap.get(lineParameters[0]),
                    lineParameters[1], Integer.parseInt(lineParameters[2])));
        }
        return fruitOperations;
    }
}
