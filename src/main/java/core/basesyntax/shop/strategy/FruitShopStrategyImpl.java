package core.basesyntax.shop.strategy;

import core.basesyntax.shop.service.FruitShopService;
import core.basesyntax.shop.service.Operations;
import core.basesyntax.shop.service.impl.FruitShopServiceAdd;
import core.basesyntax.shop.service.impl.FruitShopServiceSubtract;
import java.util.HashMap;
import java.util.Map;

public class FruitShopStrategyImpl implements FruitShopStrategy {
    private static Map<String, Class<? extends FruitShopService>>
            operationsService = new HashMap<>();

    static {
        operationsService.put(Operations.BALANCE.getOperationCode(),
                FruitShopServiceAdd.class);
        operationsService.put(Operations.SUPPLY.getOperationCode(),
                FruitShopServiceAdd.class);
        operationsService.put(Operations.RETURN_BACK.getOperationCode(),
                FruitShopServiceAdd.class);
        operationsService.put(Operations.PURCHASE.getOperationCode(),
                FruitShopServiceSubtract.class);
    }

    @Override
     public Class<? extends FruitShopService> chooseStrategy(String type) {
        return operationsService.get(type);
    }
}
