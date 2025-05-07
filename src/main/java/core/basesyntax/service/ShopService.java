package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;
import java.util.List;

public interface ShopService {
    void changeQuantityStore(List<FruitOperation> fruits);
}
