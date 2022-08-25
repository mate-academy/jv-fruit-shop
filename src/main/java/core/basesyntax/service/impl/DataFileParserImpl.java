package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.DataFileParser;

import java.util.ArrayList;
import java.util.List;

public class DataFileParserImpl implements DataFileParser<FruitOperation> {
    private static final String FILE_TITLE = "type,fruit,quantity";
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;


    @Override
    public List<FruitOperation> parseDataFile(List<String> data) {
        List<FruitOperation> fruitOperations = new ArrayList<>();
        data.stream()
                .filter(d -> !d.equals(FILE_TITLE))
                .map(d -> d.split(SEPARATOR))
                .forEach(d -> fruitOperations.add(new FruitOperation(d[OPERATION_INDEX],
                        new Fruit(d[NAME_INDEX]),
                        Integer.parseInt(d[AMOUNT_INDEX]))));
        return fruitOperations;
    }
}
