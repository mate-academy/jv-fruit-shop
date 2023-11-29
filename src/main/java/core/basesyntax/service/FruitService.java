package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitService {
    Fruit createNewFruit(String fruitName);

    void fillFruitStorage(List<String> dataFromFile);
}
