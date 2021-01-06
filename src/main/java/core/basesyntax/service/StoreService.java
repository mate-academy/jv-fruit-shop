package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface StoreService<T extends Fruit> {
    void getDataFromFile(String filePath);

    List<T> getFruitsBalance(List<String> data);
}
