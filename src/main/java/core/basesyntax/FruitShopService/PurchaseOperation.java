package core.basesyntax.FruitShopService;

import core.basesyntax.DB.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperation implements Operation {
    public static final int INVALID_QUANTITY = 0;
    @Override
    public void process(FruitTransaction fruitTransaction, Storage storage) {
        if(fruitTransaction.getQuantity() < INVALID_QUANTITY) {
            throw new RuntimeException("Sorry insufficient amount for purchase , come back again later ");
        }
        int currentBalance = fruitTransaction.getQuantity();
        if(fruitTransaction.getQuantity() > currentBalance) {
            throw new RuntimeException("Exceeded stock amount for purchase, can't be done");
        }
        storage.add(fruitTransaction, fruitTransaction.getQuantity());
    }
}
