package core.basesyntax.services.shopService;

import core.basesyntax.models.FruitTransaction;

import java.util.List;

public interface IShopService {
    void process(List<FruitTransaction> fruitTransactions);
}
