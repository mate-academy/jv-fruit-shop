package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.impl.handlers.BalanceOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.PurchaseOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.ReturnOperationHandlerImpl;
import core.basesyntax.service.impl.handlers.SupplyOperationHandlerImpl;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //Filling   Map<FruitTransaction.Operation, OperationHandler> strategies
        Map<FruitTransaction.Operation, OperationHandler> strategies = new HashMap<>();
        strategies.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandlerImpl());
        strategies.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandlerImpl());
    }
}
