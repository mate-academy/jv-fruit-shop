package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface ShopService {
    List<Fruit> updatingFruitStorage(List<String> data);
}
