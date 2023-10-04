package core.basesyntax.service.operation;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;

public class BalanceOperation implements OperationHandler {
    private FruitTransactionDao fruitTransactionDao;
    private FruitTransactionService fruitTransactionService;

    public BalanceOperation(FruitTransactionDao fruitTransactionDao,
                            FruitTransactionService fruitTransactionService) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.fruitTransactionService = fruitTransactionService;
    }

    @Override
    public void operation(FruitTransaction fruitTransaction) {
        fruitTransactionService.createNewFruitTransaction(fruitTransaction.getFruit(),
                fruitTransaction.getQuantity());
    }
}
