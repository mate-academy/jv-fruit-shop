package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionProcessorService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationStrategyImpl;
import core.basesyntax.strategy.impl.ReturnOperationStrategyImpl;
import core.basesyntax.strategy.impl.SupplyOperationStrategyImpl;
import java.util.List;

public class TransactionProcessorServiceImpl implements TransactionProcessorService {

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        OperationStrategy operation;

        for (FruitTransaction transaction : transactions) {
            operation = switch (transaction.getOperation()) {
                case BALANCE -> new BalanceOperationStrategyImpl();
                case RETURN -> new ReturnOperationStrategyImpl();
                case SUPPLY -> new SupplyOperationStrategyImpl();
                case PURCHASE -> new PurchaseOperationStrategyImpl();
            };

            operation.performOperation(transaction);
        }
    }
}
