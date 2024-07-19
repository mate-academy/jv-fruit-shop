package core.basesyntax.service;

import core.basesyntax.domain.Fruit;

import java.util.List;

public interface ShopService {
    void process(List<Fruit> transactions);
}
