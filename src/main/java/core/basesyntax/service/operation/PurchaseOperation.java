package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;

public class PurchaseOperation implements Operation {
    @Override
    public void processWithTransaction(FruitTransaction transaction) {
        ShopService shopService = new ShopServiceImpl();
        FruitTransaction newTransaction = new FruitTransaction(FruitTransaction.Operation.PURCHASE,
                transaction.getFruit(),
                transaction.getQuantity());
        shopService.purchaseFruit(newTransaction);
    }
}
