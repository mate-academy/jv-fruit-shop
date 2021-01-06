package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.StoreService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.validator.OperationValidator;
import core.basesyntax.validator.OperationValidatorImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreServiceImpl<T extends Fruit> implements StoreService<T> {
    private static final String COMA = ",";
    private static final int FIRST_POSITION = 0;
    private static final int SECOND_POSITION = 1;
    private static final int THIRD_POSITION = 2;
    private FruitDao fruitDao;
    private OperationStrategy operationStrategy;
    private List<String> operations;

    public StoreServiceImpl(FruitDao fruitsDao, OperationStrategy operationStrategy) {
        this.fruitDao = fruitsDao;
        this.operationStrategy = operationStrategy;
        operations = operationStrategy.getListOfOperations();
    }

    @Override
    public void getDataFromFile(String filePath) {
        CsvFileReader fileReaderService = new CsvFileReaderImpl(filePath);
        String[] lines = fileReaderService.getDataFromFile(filePath);
        fruitDao.setData(Arrays.asList(lines));
    }

    @Override
    public List<T> getFruitsBalance(List<String> data) {
        List<T> fruits = new ArrayList<>();
        Integer value;
        String operation;
        for (int i = 0; i < data.size(); i++) {
            Fruit fruit = new Fruit();
            operation = data.get(i).split(COMA)[FIRST_POSITION];
            fruit.setName(data.get(i).split(COMA)[SECOND_POSITION]);
            value = Integer.parseInt(data.get(i).split(COMA)[THIRD_POSITION]);
            OperationValidator operationValidator = new OperationValidatorImpl();
            operationValidator.validationCheck(operations, operation);
            if (!fruits.contains(fruit)) {
                fruit.setAmount(value);
                fruits.add((T) fruit);
            } else {
                Fruit current = fruits.get(fruits.indexOf(fruit));
                current.setAmount(operationStrategy.get(operation)
                        .updateBalance(current.getAmount(), value));
            }
        }
        return fruits;
    }
}
