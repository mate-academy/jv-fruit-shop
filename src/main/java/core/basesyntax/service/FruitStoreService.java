package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.List;

public interface FruitStoreService {
    List<Fruit> changeBalanceFruit(List<String> text);
}
