package core.basesyntax.service;

import core.basesyntax.model.FruitBox;
import java.util.List;

public interface FruitService {
    FruitBox createFruitBox(String fruitType, int value);

    void updatingFruitBox(List<String> data);
}
