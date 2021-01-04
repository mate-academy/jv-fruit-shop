package core.basesyntax.service;

import core.basesyntax.model.objects.Plant;
import java.util.List;

public interface StoreService<T extends Plant> {
    void getDataFromFile(String filePath);

    List<T> getPlantsBalance(List<String> data);
}
