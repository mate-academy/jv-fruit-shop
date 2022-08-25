package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.DataFileParser;

import java.util.ArrayList;
import java.util.List;

public class DataFileParserImpl implements DataFileParser<FruitOperation> {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;


    @Override
    public List<FruitOperation> parseDataFile(List<String> data) {
        List<FruitOperation> fruitOperations = new ArrayList<>();

        for (String line : data.subList(1, data.size())) {
            FruitOperation fruitOperation = new FruitOperation();
            String[] splitLine = line.split(SEPARATOR);
            String letter = splitLine[OPERATION_INDEX];
            String name = splitLine[NAME_INDEX];
            int amount = Integer.parseInt(splitLine[AMOUNT_INDEX]);

            fruitOperation.setOperation(letter);
            fruitOperation.setFruit(new Fruit(name));
            fruitOperation.setAmount(amount);

            fruitOperations.add(fruitOperation);
        }
        return fruitOperations;
    }
}
