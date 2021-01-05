package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.validator.OperationValidationImpl;
import core.basesyntax.service.validator.OperationValidation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final Integer OPERATION_POSITION = 0;
    private static final Integer FRUIT_NAME_POSITION = 1;
    private static final Integer VALUE_POSITION = 2;
    private FruitsDao fruitsDao;
    private OperationStrategy operationStrategy;
    private List<String> operations;

    public FruitServiceImpl(FruitsDao fruitsDao, OperationStrategy operationStrategy) {
        this.fruitsDao = fruitsDao;
        this.operationStrategy = operationStrategy;
        operations = operationStrategy.getListOfOperations();
    }

    @Override
    public void calculateFruitsBalance(List<String> data) {
        List<Fruit> fruits = fruitsDao.getData();
        Integer value;
        String operation;
        OperationValidation operationValidator = new OperationValidationImpl();
        for (String s : data) {
            Fruit fruit = new Fruit();
            operation = s.split(",")[OPERATION_POSITION];
            fruit.setName(s.split(",")[FRUIT_NAME_POSITION]);
            value = Integer.parseInt(s.split(",")[VALUE_POSITION]);

            operationValidator.isValidOperation(operations, operation);

            if (!fruits.contains(fruit)) {
                fruit.setBalance(0);
                fruits.add(fruit);
            }
            Fruit current = fruits.get(fruits.indexOf(fruit));
            current.setBalance(operationStrategy.get(operation)
                    .updateBalance(current.getBalance(), value));
        }
        fruitsDao.setData(fruits);
    }
}
