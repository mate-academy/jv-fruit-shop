package service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.Fruit;
import service.Handler;

public class HandlerImpl implements Handler {

    @Override
    public Map<String, Integer> processingData(List<Fruit> fruitsList) {
        return fruitsList.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitName,
                        Collectors.summingInt(Fruit::getFruitCount)));
    }
}
