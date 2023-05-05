package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface FileProcessing {
    void add(List<Fruit> fruitList);

    List<FruitTransaction> getListOfTransaction();
}
