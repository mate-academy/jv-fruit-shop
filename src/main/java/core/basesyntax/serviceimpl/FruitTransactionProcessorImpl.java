package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.OperationHandler;
import java.util.List;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private static final OperationHandler BALANCE = new BalanceHandler();
    private static final OperationHandler SUPPLY = new SupplyHandler();
    private static final OperationHandler PURCHASE = new PurchaseHandler();
    private static final OperationHandler RETURN = new ReturnHandler();

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions
                .forEach(t -> {
                    BALANCE.handle(t);
                    SUPPLY.handle(t);
                    PURCHASE.handle(t);
                    RETURN.handle(t);
                });
    }
}
