package core.basesyntax.service;

import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.strategy.ShopOperationStrategy;
import java.util.List;

public class FruitShopDataProcessorService implements DataProcessorService {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    private final ShopOperationStrategy shopOperationStrategy;

    public FruitShopDataProcessorService(ShopOperationStrategy shopOperationStrategy) {
        this.shopOperationStrategy = shopOperationStrategy;

    }

    @Override
    public void processData(List<String> data) {
        for (String temp : data) {
            String[] split = temp.split(",");
            ShopOperationHandler shopOperationHandler =
                    shopOperationStrategy.get(split[OPERATION_INDEX]);
            shopOperationHandler.doOperation(split[FRUIT_INDEX],
                    split[QUANTITY_INDEX]);
        }
    }
}
