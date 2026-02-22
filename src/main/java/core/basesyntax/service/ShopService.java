package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.transaction.FruitTransaction;
import java.util.List;

public interface ShopService {
    void process(List<FruitTransaction> transactions, FruitDao fruitDao);
}
