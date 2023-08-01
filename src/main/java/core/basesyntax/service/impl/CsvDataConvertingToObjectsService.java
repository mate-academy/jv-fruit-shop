package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConvertingToObjectsService;
import core.basesyntax.service.FileReaderService;

import java.util.ArrayList;
import java.util.List;

public class CsvDataConvertingToObjectsService implements DataConvertingToObjectsService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int NUMBER_OF_FRUITS_INDEX = 2;
    private FileReaderService fileReader;

    public CsvDataConvertingToObjectsService(FileReaderService fileReader) {
        this.fileReader = fileReader;
    }

    @Override
    public List<Fruit> convertDataToObjects() {
        List<Fruit> fruits = new ArrayList<>();
        String[] data = fileReader.readFromFile().split("\\n");
        for (int i = 1; i < data.length; i++) {
            Fruit fruit = createFruitObjectFromData(data[i]);
            fruits.add(fruit);
        }
        return fruits;
    }

    private Fruit createFruitObjectFromData(String data) {
        DataValidatorService validator = new DataValidatorService();
        String[] fieldsOfInfo = data.replaceAll("\\r", "").split(",");
        String name = fieldsOfInfo[FRUIT_NAME_INDEX];
        Integer quantity = Integer.valueOf(fieldsOfInfo[NUMBER_OF_FRUITS_INDEX]);
        String operation = fieldsOfInfo[OPERATION_INDEX];

        validator.isValid(operation, name, quantity);
        return new Fruit(name, quantity, Operation.of(operation));
    }


}
