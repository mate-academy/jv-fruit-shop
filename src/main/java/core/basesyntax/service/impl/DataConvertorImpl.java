package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.DataConvertor;
import java.util.List;
import java.util.stream.Collectors;

public class DataConvertorImpl implements DataConvertor {
    private static final int NUMBER_OF_NON_DATA_TABLE_ROW = 1;
    private static final String DATA_SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final int MINIMAL_READ_DATA_SIZE = 2;

    @Override
    public List<Fruit> convertData(List<String> readData) {
        if (readData == null || readData.isEmpty() || readData.size() < MINIMAL_READ_DATA_SIZE) {
            throw new IllegalArgumentException("Invalid readFromFile data");
        }
        return readData.stream()
                .skip(NUMBER_OF_NON_DATA_TABLE_ROW)
                .map(this::modifyData)
                .collect(Collectors.toList());
    }

    private Fruit modifyData(String read) {
        Fruit fruit = new Fruit();
        String [] data = read.split(DATA_SEPARATOR);
        fruit.setOperation(Fruit.Operation.getByCode(data[INDEX_OF_OPERATION]));
        fruit.setFruit(data[INDEX_OF_FRUIT_TYPE]);
        fruit.setQuantity(Integer.parseInt(data[INDEX_OF_QUANTITY]));
        return fruit;
    }
}
