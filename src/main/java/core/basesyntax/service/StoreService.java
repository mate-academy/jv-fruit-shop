package core.basesyntax.service;

import core.basesyntax.model.Plant;
import java.util.List;

public interface StoreService<T extends Plant> {
    void getDataFromFile(String filePath);

    List<T> getFruitsBalance(List<String> data);
}
