package core.basesyntax.shopservice;

import core.basesyntax.fruittransaction.FruitTransaction;
import core.basesyntax.fruittransaction.Operation;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions
                .forEach(transaction -> {
                    Operation op = transaction.getOperation();
                    OperationHandler handler = strategy.getTransactionHandler(op);
                    handler.updateData(transaction);
                });

    }
}
