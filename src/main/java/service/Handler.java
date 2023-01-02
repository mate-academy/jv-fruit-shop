package service;

import java.util.List;
import java.util.Map;
import model.Fruit;

public interface Handler {
    Map<String, Integer> processingData(List<Fruit> fruitsList);
}
