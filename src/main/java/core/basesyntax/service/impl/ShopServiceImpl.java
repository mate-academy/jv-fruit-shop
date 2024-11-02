package core.basesyntax.service.impl;

import core.basesyntax.model.ShopOperation;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.StrategyOperationService;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final StrategyOperationService strategyOperationService;

    public ShopServiceImpl(StrategyOperationService strategyOperationService) {
        this.strategyOperationService = strategyOperationService;
    }

    @Override
    public void process(List<ShopOperation> operations) {
        for (ShopOperation operation : operations) {
            strategyOperationService.get(operation.getType()).handle(operation);
        }
    }
}
