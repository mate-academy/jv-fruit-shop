package core.basesyntax.service;

import core.basesyntax.datemanipulation.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions);
}
