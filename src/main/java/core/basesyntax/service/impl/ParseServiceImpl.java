package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.ArrayList;
import java.util.List;

public class ParseServiceImpl implements ParseService {
    private static final int START_POINT = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseInputData(List<String> inputData) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (int i = START_POINT; i < inputData.size(); i++) {
            parsedData.add(parseLine(inputData.get(i)));
        }
        return parsedData;
    }

    private FruitTransaction parseLine(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        String[] lines = line.split(SEPARATOR);
        fruitTransaction.setOperation(
                FruitTransaction.Operation.getOperationByCode(lines[OPERATION_INDEX]));
        fruitTransaction.setFruit(lines[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(lines[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
