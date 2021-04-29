package core.basesyntax.service.validation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.OperationStrategy;
import java.util.List;

public class ValidatorImpl implements Validator {
    private static final List<String> VALID_OPERATIONS = List.of("b", "r", "s", "p");
    private static final String SEPARATOR = ",";
    private static final String BALANCE = "b";
    private OperationStrategy strategy;
    private FruitDao fruitDao;

    public ValidatorImpl(OperationStrategy strategy, FruitDao fruitDao) {
        this.strategy = strategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public void validateFile(String lineFromFile) {
        String[] fields = lineFromFile.split(SEPARATOR);
        String operator = fields[0];
        String fruitName = fields[1];
        int capacity = Integer.parseInt(fields[2]);
        if (capacity < 0) {
            throw new RuntimeException("Can`t carry out operation with negative quantity");
        }
        if (!VALID_OPERATIONS.contains(operator)) {
            throw new RuntimeException("Invalid activity signature : " + operator);
        }
        if (operator.equals(BALANCE) && !fruitDao.containFruit(fruitName)) {
            strategy.get(operator).doOperationWithFruit(new FruitDto(fruitName, capacity));
            return;
        }
        if (!fruitDao.containFruit(fruitName)) {
            throw new RuntimeException("Can`t carry out operation "
                    + "with unregistered fruit : " + fruitName);
        }
        if (!operator.equals(BALANCE)) {
            strategy.get(operator).doOperationWithFruit(new FruitDto(fruitName, capacity));
            if (fruitDao.getQuantity(fruitName) >= 0) {
                return;
            } else {
                throw new RuntimeException("Invalid quantity order");
            }
        }
        throw new RuntimeException("Invalid file");
    }
}
