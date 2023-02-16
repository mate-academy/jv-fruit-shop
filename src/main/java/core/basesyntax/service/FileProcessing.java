package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface FileProcessing {
    void add(FruitTransaction fruitTransaction);

    List<FruitTransaction> get();

    void update(Map<String, Integer> newData);
}
