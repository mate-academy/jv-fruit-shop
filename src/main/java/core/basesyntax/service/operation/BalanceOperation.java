package core.basesyntax.service.operation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;

public class BalanceOperation implements Operation {

    @Override
    public void processWithTransaction(FruitTransaction transaction) {
        ShopService shopService = new ShopServiceImpl();
        FruitTransaction newTransaction = new FruitTransaction(FruitTransaction.Operation.BALANCE,
                transaction.getFruit(),
                transaction.getQuantity());
        shopService.balanceOfFruit(newTransaction);
    }
}
