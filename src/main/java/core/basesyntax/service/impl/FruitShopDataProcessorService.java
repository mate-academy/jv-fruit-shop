package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
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
    public void processData(List<FruitTransaction> data) {
        for (FruitTransaction transaction : data) {
            shopOperationStrategy.get(transaction.getOperation()).handle(transaction);
        }
    }
}
