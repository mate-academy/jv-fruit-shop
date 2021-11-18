package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;
import java.util.Map;

public interface ShopService {
    void updatingFruitStorage(List<String> data);

    Map<String, Long> amountCalculator(List<Fruit> fruits);
}
