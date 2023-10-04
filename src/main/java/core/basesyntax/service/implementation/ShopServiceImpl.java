package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.FruitShopOperationsHandler;
import core.basesyntax.strategy.StrategyImplementation;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    @Override
    public void process(FruitTransaction transaction, Map<FruitTransaction.Operation,
            FruitShopOperationsHandler> processSelector) {
        StrategyImplementation strategyImplementation = new StrategyImplementation(processSelector);
        FruitShopOperationsHandler handler
                = strategyImplementation.getProcessSelector().get(transaction.getOperation());
        handler.applyOperation(transaction.getFruit(), transaction.getQuantity());
    }
}
