package core.basesyntax.service.validation;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.strategy.FruitOperations;
import core.basesyntax.dto.FruitDto;
import java.util.List;
import java.util.Map;

public class ValidatorImpl implements Validator {
    private static final List<String> VALID_OPERATIONS = List.of("b", "r", "s", "p");
    private static final String BALANCE = "b";
    private Map<String, FruitOperations> operationsMap;
    private FruitDao fruitDao;

    public ValidatorImpl(Map<String, FruitOperations> operationsMap, FruitDao fruitDao) {
        this.operationsMap = operationsMap;
        this.fruitDao = fruitDao;
    }

    @Override
    public void validateFile(FruitDto fruitDto) {
        String operator = fruitDto.getActivity();
        String fruitName = fruitDto.getFruitName();
        int capacity = fruitDto.getQuantity();
        if (capacity < 0) {
            throw new RuntimeException("Can`t carry out operation with negative quantity");
        }
        if (!VALID_OPERATIONS.contains(operator)) {
            throw new RuntimeException("Invalid activity signature : " + operator);
        }
        if (operator.equals(BALANCE) && !fruitDao.containFruit(fruitName)) {
            operationsMap.get(operator).doOperationWithFruit(fruitDto);
            return;
        }
        if (!fruitDao.containFruit(fruitName)) {
            throw new RuntimeException("Can`t carry out operation "
                    + "with unregistered fruit : " + fruitName);
        }
        if (!operator.equals(BALANCE)) {
            operationsMap.get(operator).doOperationWithFruit(fruitDto);
            if (fruitDao.getQuantity(fruitName) >= 0) {
                return;
            } else {
                throw new RuntimeException("Invalid quantity order");
            }
        }
        throw new RuntimeException("Invalid file");
    }
}
