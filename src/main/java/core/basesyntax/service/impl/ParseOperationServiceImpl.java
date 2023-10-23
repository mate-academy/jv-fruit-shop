package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseOperationService;
import java.util.ArrayList;
import java.util.List;

public class ParseOperationServiceImpl implements ParseOperationService {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int POINT_TO_START_READING = 1;

    @Override
    public List<FruitTransaction> parseContentForOperations(List<String> inputData) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (int i = 1; i < inputData.size(); i++) {
            parsedData.add(parseInputData(inputData.get(i)));
        }
        return parsedData;
    }

    private FruitTransaction parseInputData(String line) {
        FruitTransaction fruitTransaction = new FruitTransaction(
        );
        String[] separetedLine = line.split(SEPARATOR);
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getOperationByCode(separetedLine[OPERATION_INDEX]));
        fruitTransaction.setFruit(separetedLine[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(separetedLine[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
