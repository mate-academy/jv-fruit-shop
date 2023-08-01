package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataProcesser;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.List;

public class OperationProcess implements DataProcesser {
    public void processData(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler;
            switch (transaction.getOperation()) {
                case BALANCE: handler = new BalanceOperation();
                    break;
                case PURCHASE: handler = new PurchaseOperation();
                    break;
                case RETURN: handler = new ReturnOperation();
                    break;
                case SUPPLY: handler = new SupplyOperation();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: "
                            + transaction.getOperation());
            }
            handler.update(transaction.getFruit(), transaction.getQuantity());
        }
    }
}
