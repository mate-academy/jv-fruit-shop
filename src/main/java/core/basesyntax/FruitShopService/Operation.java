package core.basesyntax.FruitShopService;

import core.basesyntax.DB.Storage;
import core.basesyntax.model.FruitTransaction;

public interface Operation {

    void process(FruitTransaction fruitTransaction, Storage storage);
}
