package core.basesyntax.services.impl;

import core.basesyntax.constvars.Constants;
import core.basesyntax.exception.ValidationDataException;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.CreateTaskService;
import java.util.ArrayList;
import java.util.List;

public class CreateTaskServiceImpl implements CreateTaskService {
    @Override
    public List<FruitTransaction> createTasks(List<String[]> parseData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (String[] readLine : parseData) {
            FruitTransaction.ActionType typeOfTask = null;
            for (FruitTransaction.ActionType type : FruitTransaction.ActionType.values()) {
                if (type.getType().equals(readLine[Constants.INDEX_OF_ACTION])) {
                    typeOfTask = type;
                    break;
                }
            }
            if (typeOfTask == null) {
                throw new ValidationDataException("Type is not exist");
            }

            String nameOfProduct = readLine[Constants.INDEX_OF_NAME];
            if (nameOfProduct == null) {
                throw new ValidationDataException("Name of Product cant be null");
            }

            if (nameOfProduct.isEmpty()) {
                throw new ValidationDataException("Name of Product cant be empty");
            }

            Integer valueOfLine = Integer.parseInt(readLine[Constants.INDEX_OF_VALUE]);
            if (valueOfLine < Constants.NUM_ZERO) {
                throw new ValidationDataException("Value cant be less than " + Constants.NUM_ZERO);
            }
            fruitTransactions.add(new FruitTransaction(typeOfTask, nameOfProduct, valueOfLine));
        }
        return fruitTransactions;
    }
}
