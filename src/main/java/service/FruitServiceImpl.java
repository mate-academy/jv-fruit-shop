package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.Fruit;
import strategy.OperationStrategy;

public class FruitServiceImpl implements FruitService {
    private OperationStrategy operationStrategy;

    public FruitServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public List<Fruit> getReport(List<Fruit> fruits) {
        List<Fruit> reportFruitsList = new ArrayList<>();
        List<String> unicFruitsNameList = getUnicFruitName(fruits);
        for (String name:unicFruitsNameList) {
            int balanceQuatity = getTotalUnicFruitQuatity(name,fruits);
            Fruit fruit = new Fruit(Fruit.Operation.BALANCE,name,balanceQuatity);
            reportFruitsList.add(fruit);
        }
        return reportFruitsList;
    }

    private List<String> getUnicFruitName(List<Fruit> fruits) {
        Set<String> unicFruitsNameSet = fruits
                .stream()
                .map(Fruit::getName)
                .collect(Collectors.toSet());
        return new ArrayList<>(unicFruitsNameSet);
    }

    private int getTotalUnicFruitQuatity(String unicFruitName,List<Fruit> fruits) {
        return fruits.stream()
                .filter(fruit -> fruit.getName().equals(unicFruitName))
                .mapToInt(c -> operationStrategy
                        .get(c.getTypeOperation())
                        .getOperationQuantity(c.getQuantity()))
                .sum();
    }
}
