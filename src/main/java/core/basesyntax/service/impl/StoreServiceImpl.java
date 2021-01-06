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
            operation = data.get(i).split(",")[0];
            fruit.setName(data.get(i).split(",")[1]);
            value = Integer.parseInt(data.get(i).split(",")[2]);
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
