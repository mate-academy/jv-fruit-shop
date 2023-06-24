package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionHandler;
import core.basesyntax.service.impl.FruitBalanceService;
import core.basesyntax.service.impl.FruitPurchaseService;
import core.basesyntax.service.impl.FruitReturnService;
import core.basesyntax.service.impl.FruitSupplyService;
import java.util.HashMap;
import java.util.Map;

public class FruitTransactionStrategy {
    private final Map<FruitTransaction.Operation, FruitTransactionHandler> handlerMap;

    public FruitTransactionStrategy() {
        handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new FruitPurchaseService());
        handlerMap.put(FruitTransaction.Operation.BALANCE, new FruitBalanceService());
        handlerMap.put(FruitTransaction.Operation.RETURN, new FruitReturnService());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new FruitSupplyService());
    }

    public FruitTransactionHandler getFruitTransactionService(
            FruitTransaction.Operation operation) {
        switch (operation) {
            case PURCHASE:
                return handlerMap.get(FruitTransaction.Operation.PURCHASE);
            case SUPPLY:
                return handlerMap.get(FruitTransaction.Operation.SUPPLY);
            case RETURN:
                return handlerMap.get(FruitTransaction.Operation.RETURN);
            case BALANCE:
                return handlerMap.get(FruitTransaction.Operation.BALANCE);
            default:
                throw new RuntimeException("Illegal operation");
        }
    }
}
