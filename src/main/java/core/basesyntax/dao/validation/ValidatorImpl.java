package core.basesyntax.dao.validation;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.db.Storage;
import java.util.List;

public class ValidatorImpl implements Validator {
    private static final List<String> VALID_OPERATIONS = List.of("b", "r", "s", "p");
    private static final String SEPARATOR = ",";
    private static final String BALANCE = "b";
    private static final String INVALID_FILE = "Invalid file";
    private static final String NEGATIVE_NUMBER = "Can`t carry out operation "
            + "with negative quantity";
    private static final String UNREGISTERED_FRUIT = "Can`t carry out operation "
            + "with unregistered fruit :";
    private static final String INVALID_ACTIVITY = "Invalid activity signature :";
    private static final String INVALID_QUANTITY = "Invalid quantity order";
    private OperationStrategy strategy;

    public ValidatorImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void validateFile(String lineFromFile) {
        String[] fields = lineFromFile.split(SEPARATOR);
        String operator = fields[0];
        String fruitName = fields[1];
        int capacity = Integer.parseInt(fields[2]);
        if (capacity < 0) {
            throw new RuntimeException(NEGATIVE_NUMBER);
        }
        if (!VALID_OPERATIONS.contains(operator)) {
            throw new RuntimeException(INVALID_ACTIVITY + operator);
        }
        if (operator.equals(BALANCE) && !Storage.getFruits().containsKey(fruitName)) {
            strategy.get(operator).fruitActivity(fruitName, capacity);
            return;
        }
        if (!Storage.getFruits().containsKey(fruitName)) {
            throw new RuntimeException(UNREGISTERED_FRUIT + fruitName);
        }
        if (!operator.equals(BALANCE)) {
            strategy.get(operator).fruitActivity(fruitName, capacity);
            if (Storage.getFruits().get(fruitName) >= 0) {
                return;
            } else {
                throw new RuntimeException(INVALID_QUANTITY);
            }
        }
        throw new RuntimeException(INVALID_FILE);
    }
}
