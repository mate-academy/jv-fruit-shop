package core.basesyntax.serviceimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.OperationService;
import java.util.List;

public class OperationServiceImpl implements OperationService {
    private static final OperationHandler BALANCE = new BalanceHandler();
    private static final OperationHandler SUPPLY = new SupplyHandler();
    private static final OperationHandler PURCHASE = new PurchaseHandler();
    private static final OperationHandler RETURN = new ReturnHandler();

    @Override
    public void applyAll(List<FruitTransaction> transactions) {
        BALANCE.apply(transactions);
        SUPPLY.apply(transactions);
        PURCHASE.apply(transactions);
        RETURN.apply(transactions);
    }
}

