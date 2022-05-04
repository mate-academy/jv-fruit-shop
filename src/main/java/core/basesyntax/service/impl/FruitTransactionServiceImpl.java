package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.strategy.impl.BalanceHandler;
import core.basesyntax.service.strategy.impl.PurchaseHandler;
import core.basesyntax.service.strategy.impl.ReturnHandler;
import core.basesyntax.service.strategy.impl.SupplyHandler;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private FruitDao fruitDao;

    public FruitTransactionServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactions) {
        for (FruitTransaction transaction : fruitTransactions) {
            switch (transaction.getOperation().name()) {
                case "BALANCE":
                    new BalanceHandler(fruitDao).handle(transaction.getFruit());
                    break;
                case "SUPPLY":
                    new SupplyHandler(fruitDao).handle(transaction.getFruit());
                    break;
                case "PURCHASE":
                    new PurchaseHandler(fruitDao).handle(transaction.getFruit());
                    break;
                case "RETURN":
                    new ReturnHandler(fruitDao).handle(transaction.getFruit());
                    break;

                default:
                    throw new IllegalStateException("Unexpected value: "
                            + transaction.getOperation().name());
            }
        }
    }
}
