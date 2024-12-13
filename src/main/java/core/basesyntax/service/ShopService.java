package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.Map;

public interface ShopService {
    //обробляє список транзакцій
    void process(List<FruitTransaction> transactions);

    Map<String, Integer> getInventory();
}
