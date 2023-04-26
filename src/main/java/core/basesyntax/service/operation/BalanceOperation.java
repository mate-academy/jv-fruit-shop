package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoIml;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.FruitTransactionServiceImpl;

public class BalanceOperation implements OperationHandler {
    private final FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoIml();
    private final FruitTransactionService fruitTransactionService
            = new FruitTransactionServiceImpl(fruitTransactionDao);

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        fruitTransactionService.createNewFruitTransaction(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
