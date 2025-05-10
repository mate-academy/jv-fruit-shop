package core.basesyntax.service.shopservice;

import core.basesyntax.model.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> fruitTransactions);
}
