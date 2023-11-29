package core.basesyntax.service;

import java.util.List;

public interface DataService {
    void fillFruitStorage(List<String> dataFromFile);

    List<String> formatAndCheckData(List<String> dataFromFile);
}
