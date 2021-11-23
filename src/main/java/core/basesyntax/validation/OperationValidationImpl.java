package core.basesyntax.validation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;

public class OperationValidationImpl implements OperationValidation {
    private static final int CORRECT_LENGTH_OF_SPLITTED_ROW = 3;
    private static final int INDEX_FRUIT_AMOUNT = 2;
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_FRUIT_TYPE = 1;

    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public boolean isOperationValid(String[] data, String fromFileName) {
        Fruit fruit = new Fruit(data[INDEX_FRUIT_TYPE]);
        if (data.length != CORRECT_LENGTH_OF_SPLITTED_ROW
                || !data[INDEX_FRUIT_AMOUNT].matches("\\d+")
                || Integer.parseInt(data[INDEX_FRUIT_AMOUNT]) < 0
                || !data[INDEX_FRUIT_TYPE].matches("[A-Za-z]+")
                || !containsOperation(data[INDEX_OPERATION_TYPE])
                || Operation.valueOf(data[INDEX_OPERATION_TYPE])
                == Operation.p
                && Integer.parseInt(data[INDEX_FRUIT_AMOUNT])
                > fruitDao.getStorage().get(fruit)) {
            throw new RuntimeException("Data in file " + fromFileName + " is not valid");
        }
        return true;
    }

    private boolean containsOperation(String test) {
        for (Operation c : Operation.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
