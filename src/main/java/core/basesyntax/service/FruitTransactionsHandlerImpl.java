package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.strategy.FruitTransactionStrategy;
import java.util.List;

public class FruitTransactionsHandlerImpl implements FruitTransactionsHandler {
    private FruitTransactionStrategy fruitTransactionStrategy;

    public FruitTransactionsHandlerImpl(
            FruitTransactionStrategy fruitTransactionStrategy) {
        this.fruitTransactionStrategy = fruitTransactionStrategy;
    }

    @Override
    public void handle(List<FruitTransaction> fruitTransactions) {
        FruitTransactionValidator fruitTransactionValidator = new FruitTransactionValidatorImpl();
        for (FruitTransaction fruitTransaction : fruitTransactions) {
            fruitTransactionValidator.validate(fruitTransaction);
            fruitTransactionStrategy.getHandler(fruitTransaction)
                    .execute(fruitTransaction);
        }
    }
}
