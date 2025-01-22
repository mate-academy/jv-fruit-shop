package core.basesyntax.services;

import core.basesyntax.models.Fruit;
import java.util.List;

public interface ShopService {
    void process(List<Fruit> fruits);

    String getReport();
}
