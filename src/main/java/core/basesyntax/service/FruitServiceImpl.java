package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private static final Integer OPERATION_POSITION = 0;
    private static final Integer FRUIT_NAME_POSITION = 1;
    private static final Integer VALUE_POSITION = 2;
    private FruitsDao fruitsDao;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(FruitsDao fruitsDao, OperationStrategy operationStrategy) {
        this.fruitsDao = fruitsDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void getDataFromFile(String filePath) {
        FileReaderService fileReaderService = new FileReaderServiceImpl(filePath);
        String[] strings = fileReaderService.getDataFromFile(filePath);
        fruitsDao.setData(Arrays.asList(strings));
    }

    @Override
    public List<Fruit> getFruitsBalance(List<String> data) {
        List<Fruit> fruits = new ArrayList<>();
        Integer value;
        String operation;
        for (String s : data) {
            Fruit fruit = new Fruit();
            operation = s.split(",")[OPERATION_POSITION];
            fruit.setName(s.split(",")[FRUIT_NAME_POSITION]);
            value = Integer.parseInt(s.split(",")[VALUE_POSITION]);

            isValidValue(value);

            if (!fruits.contains(fruit)) {
                isValidOperation(operation);
                fruit.setBalance(value);
                fruits.add(fruit);
            } else {
                Fruit current = fruits.get(fruits.indexOf(fruit));
                current.setBalance(operationStrategy.get(operation)
                        .updateBalance(current.getBalance(), value));
            }
        }
        return fruits;
    }

    private void isValidValue(Integer value) {
        if (value < 0) {
            throw new RuntimeException(String.format("Buyers will not be able to buy %s units. "
                    + "%s is incorrect input.", value, value));
        }
    }

    private void isValidOperation(String operation) {
        if (!(operation.equals("s") || operation.equals("b"))) {
            throw new RuntimeException(String.format("You can't buy these fruits as there "
                    + "are not in the stock. '%s' is wrong operation.", operation));
        }
    }
}
