package core.basesyntax.services.impl;

import core.basesyntax.exception.ValidationDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.CreateTaskService;
import core.basesyntax.util.ConstantsForCsvParse;
import java.util.ArrayList;
import java.util.List;

public class CreateTaskServiceImpl implements CreateTaskService {
    private static final int NUM_ZERO = 0;

    @Override
    public List<FruitTransaction> createTasks(List<String[]> parseData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String[] readLine : parseData) {
            FruitTransaction.ActionType typeOfTask = null;
            for (FruitTransaction.ActionType type : FruitTransaction.ActionType.values()) {
                if (type.getType().equals(readLine[ConstantsForCsvParse.INDEX_OF_ACTION])) {
                    typeOfTask = type;
                    break;
                }
            }
            String nameOfProduct = readLine[ConstantsForCsvParse.INDEX_OF_NAME];
            Integer valueOfLine = Integer.parseInt(readLine[ConstantsForCsvParse.INDEX_OF_VALUE]);
            validateData(typeOfTask, nameOfProduct, valueOfLine);
            fruitTransactions.add(new FruitTransaction(typeOfTask, nameOfProduct, valueOfLine));
        }
        return fruitTransactions;
    }

    private void validateData(FruitTransaction.ActionType typeOfTask,
                              String nameOfProduct, Integer valueOfLine) {
        if (typeOfTask == null) {
            throw new ValidationDataException("Type is not exist");
        }
        if (nameOfProduct == null) {
            throw new ValidationDataException("Name of Product cant be null");
        }
        if (nameOfProduct.isEmpty()) {
            throw new ValidationDataException("Name of Product cant be empty");
        }
        if (valueOfLine < NUM_ZERO) {
            throw new ValidationDataException("Value cant be less than " + NUM_ZERO);
        }
    }
}
