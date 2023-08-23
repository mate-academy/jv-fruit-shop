package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.FruitTransactionStrategy;
import java.util.List;

public class FruitServiceForHandleTransactionsImpl implements FruitServiceForHandleTransactions {
    private FruitDao fruitDao;
    private FruitItemService fruitItemService;
    private FruitTransactionStrategy fruitTransactionStrategy;

    public FruitServiceForHandleTransactionsImpl(
            FruitDao fruitDao,
            FruitItemService fruitItemService,
            FruitTransactionStrategy fruitTransactionStrategy) {
        this.fruitDao = fruitDao;
        this.fruitItemService = fruitItemService;
        this.fruitTransactionStrategy = fruitTransactionStrategy;
    }

    @Override
    public void handle(List<FruitTransaction> fruitTransactions) {
        FruitTransactionChecker fruitTransactionChecker = new FruitTransactionCheckerImpl();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            fruitTransactionChecker.checkValue(fruitTransaction);
            fruitTransactionStrategy.getHandler(fruitTransaction)
                    .execute(fruitTransaction, fruitDao, fruitItemService);
        }
    }
}
