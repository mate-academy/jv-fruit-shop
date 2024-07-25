package core.basesyntex.service;

import core.basesyntex.model.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}
