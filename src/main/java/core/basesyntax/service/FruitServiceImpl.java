package core.basesyntax.service;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.model.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    private FruitsDao fruitsDao;
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(FruitsDao fruitsDao, OperationStrategy operationStrategy) {
        this.fruitsDao = fruitsDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void getDataFromFile(String filePath) {
        FileReaderService fileReaderService = new FileReaderServiceImpl(filePath);
        String[] strings = fileReaderService.readFromFile().split(System.lineSeparator());
        String[] updatedData = new String[strings.length - 1];
        for (int i = 0; i < updatedData.length; i++) {
            updatedData[i] = strings[i + 1];
        }
        fruitsDao.setData(Arrays.asList(updatedData));
    }

    @Override
    public List<Fruit> getFruitsBalance(List<String> data) {
        List<Fruit> fruits = new ArrayList<>();
        Integer value;
        String operation;
        for (String s : data) {
            Fruit fruit = new Fruit();
            operation = s.split(",")[0];
            fruit.setName(s.split(",")[1]);
            value = Integer.parseInt(s.split(",")[2]);
            if (!fruits.contains(fruit)) {
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
}
