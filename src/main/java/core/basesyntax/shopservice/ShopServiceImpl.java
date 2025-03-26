package core.basesyntax.shopservice;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationservice.BalanceOperationImpl;
import core.basesyntax.operationservice.OperationHandler;
import core.basesyntax.operationservice.PurchaseOperationImpl;
import core.basesyntax.operationservice.ReturnOperationImpl;
import core.basesyntax.operationservice.SupplyOperationImpl;
import core.basesyntax.operationstrategy.OperationStrategy;
import core.basesyntax.operationstrategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationImpl());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationImpl());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationImpl());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationImpl());

        this.operationStrategy = new OperationStrategyImpl(handlers); // ✅ Теперь передаём Map!
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.getHandler(transaction.getOperation()).apply(transaction);
        }
    }
}
