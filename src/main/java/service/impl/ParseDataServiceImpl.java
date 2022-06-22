package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import strategy.OperationHandler;
import service.ParseDataService;
import strategy.OperationStrategy;

public class ParseDataServiceImpl implements ParseDataService {
    private static final int TYPE_OF_OPERATION = 0;
    private static final int TYPE_OF_FRUIT = 1;
    private static final int QUANTITY_OF_FRUITS = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public List<Fruit> parseData(List<String> dataFromFile) {
        List<Fruit> parsedData = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            String[] splitedString = dataFromFile.get(i).split(CSV_SEPARATOR);
            Fruit parsedValue = new Fruit(getOperation(splitedString),
                    getTypeOfFruit(splitedString),
                    getQuantityOfFruit(splitedString));
            parsedData.add(parsedValue);
        }
        return parsedData;
    }

    private OperationHandler getOperation(String[] splitedString) {
        return OperationStrategy.getOperationServiceStrategy(splitedString[TYPE_OF_OPERATION]);
    }

    private String getTypeOfFruit(String[] splitedString) {
        return splitedString[TYPE_OF_FRUIT];
    }

    private int getQuantityOfFruit(String[] splitedString) {
        return Integer.parseInt(splitedString[QUANTITY_OF_FRUITS]);
    }
}
