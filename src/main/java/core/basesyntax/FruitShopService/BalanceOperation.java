package core.basesyntax.FruitShopService;

import core.basesyntax.DB.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperation implements Operation {

    @Override
    public void process(FruitTransaction fruitTransaction, Storage storage) {
        storage.add(fruitTransaction, fruitTransaction.getQuantity());
    }
}
