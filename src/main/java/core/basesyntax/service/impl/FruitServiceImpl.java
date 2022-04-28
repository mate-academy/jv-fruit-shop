package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.strategy.impl.BalanceHandler;
import core.basesyntax.service.strategy.impl.PurchaseHandler;
import core.basesyntax.service.strategy.impl.ReturnHandler;
import core.basesyntax.service.strategy.impl.SupplyHandler;
import java.util.List;

public class FruitServiceImpl implements FruitService {
    @Override
    public void fruitTransaction(List<FruitTransaction> fruitTransactionList) {

        for (FruitTransaction transaction : fruitTransactionList) {
            switch (transaction.getOperation().getOperation()) {
                case "b":
                    new BalanceHandler().getOperation(transaction.getFruit());
                    break;
                case "s":
                    new SupplyHandler().getOperation(transaction.getFruit());
                    break;
                case "p":
                    new PurchaseHandler().getOperation(transaction.getFruit());
                    break;
                case "r":
                    new ReturnHandler().getOperation(transaction.getFruit());
                    break;

                default:
                    throw new RuntimeException("Can`t be used operation !!");
            }
        }
    }
}
