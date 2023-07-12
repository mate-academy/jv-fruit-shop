package core.basesyntax.service.impl;

import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.service.DataProcessorService;
import core.basesyntax.strategy.ShopOperationStrategy;
import java.util.List;

public class FruitShopDataProcessorService implements DataProcessorService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private final ShopOperationStrategy shopOperationStrategy;

    public FruitShopDataProcessorService(ShopOperationStrategy shopOperationStrategy) {
        this.shopOperationStrategy = shopOperationStrategy;
    }

    @Override
    public void processData(List<String> data) {
        for (String line : data) {
            String[] split = line.split(SEPARATOR);
            ShopOperationHandler shopOperationHandler =
                    shopOperationStrategy.get(split[OPERATION_INDEX]);
            shopOperationHandler.handle(split[FRUIT_INDEX],
                    split[QUANTITY_INDEX]);
        }
    }
}
