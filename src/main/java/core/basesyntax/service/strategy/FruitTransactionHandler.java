package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitItemService;

public interface FruitTransactionHandler {
    void execute(FruitTransaction fruitTransaction,
                 FruitDao fruitDao,
                 FruitItemService fruitItemService);
}
