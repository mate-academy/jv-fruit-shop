package core.basesyntax.service;

import java.util.List;
import core.basesyntax.model.FruitTransaction;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}
