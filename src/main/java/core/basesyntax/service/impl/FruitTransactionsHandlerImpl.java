package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceHandler;
import core.basesyntax.strategy.impl.PurchaseHandler;
import core.basesyntax.strategy.impl.ReturnHandler;
import core.basesyntax.strategy.impl.SupplyHandler;
import java.util.List;

public class FruitTransactionsHandlerImpl implements FruitTransactionHandler {
    private final FruitStorage fruitStorage;
    private OperationStrategy operationStrategy = new OperationStrategy(
            new BalanceHandler(),
            new PurchaseHandler(),
            new ReturnHandler(),
            new SupplyHandler());

    public FruitTransactionsHandlerImpl(FruitStorage fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public void processTransactionsList(List<FruitTransaction> fruitTransactionList) {
        fruitTransactionList.forEach(transaction -> {
            OperationHandler strategy = operationStrategy
                    .getStrategy(transaction.getOperation());
            fruitStorage.updateFruitQuantity(transaction.getFruit(),
                    strategy.getFruitAmount(transaction.getQuantity()));
        });
    }
}
