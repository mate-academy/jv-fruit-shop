package core.basesyntax.service;

import java.util.List;

public interface DataService {
    void fillDataStorage(List<String> dataFromFile);

    void fillFruitStorage();
}
