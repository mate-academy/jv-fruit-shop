package core.basesyntax.validation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import java.math.BigDecimal;

public class OperationValidationImpl implements OperationValidation {
    private static final int CORRECT_LENGTH_OF_SPLITTED_ROW = 3;
    private static final int INDEX_FRUIT_AMOUNT = 2;
    private static final int INDEX_OPERATION_TYPE = 0;
    private static final int INDEX_FRUIT_TYPE = 1;

    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public boolean isOperationValid(String[] data, String fromFileName) {
        if (data.length != CORRECT_LENGTH_OF_SPLITTED_ROW
                || !data[INDEX_FRUIT_AMOUNT].matches("\\d+")
                || Integer.parseInt(data[INDEX_FRUIT_AMOUNT]) < 0
                || !containsFruit(data[INDEX_FRUIT_TYPE])
                || !containsOperation(data[INDEX_OPERATION_TYPE])
                || Operation.OperationKind.valueOf(data[INDEX_OPERATION_TYPE])
                == Operation.OperationKind.p
                && new BigDecimal(data[INDEX_FRUIT_AMOUNT])
                .compareTo(fruitDao.getStorage()
                        .get(Fruit.Type.valueOf(data[INDEX_FRUIT_TYPE]))) > 0) {
            throw new RuntimeException("Data in file " + fromFileName + " is not valid");
        }
        return true;
    }

    private boolean containsOperation(String test) {
        for (Operation.OperationKind c : Operation.OperationKind.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    private boolean containsFruit(String test) {
        for (Fruit.Type c : Fruit.Type.values()) {
            if (c.name().equals(test)) {
                return true;
            }
        }
        return false;
    }
}
