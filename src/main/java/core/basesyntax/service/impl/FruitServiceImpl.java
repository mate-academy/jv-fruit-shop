package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
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
        FruitDao fruitDao = new FruitDaoImpl();

        for (FruitTransaction transaction : fruitTransactionList) {
            switch (transaction.getOperation().name()) {
                case "BALANCE":
                    new BalanceHandler(fruitDao).getOperation(transaction.getFruit());
                    break;
                case "SUPPLY":
                    new SupplyHandler(fruitDao).getOperation(transaction.getFruit());
                    break;
                case "PURCHASE":
                    new PurchaseHandler(fruitDao).getOperation(transaction.getFruit());
                    break;
                case "RETURN":
                    new ReturnHandler(fruitDao).getOperation(transaction.getFruit());
                    break;

                default:
                    throw new RuntimeException("Can`t be used operation !!");
            }
        }
    }
}
