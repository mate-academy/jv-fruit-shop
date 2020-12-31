package core.basesyntax.service;

import core.basesyntax.model.Fruit;

import java.util.List;

public interface FruitService {
    void getDataFromFile(String filePath);

    List<Fruit> getFruitsBalance(List<String> data);
}
