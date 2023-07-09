package core.basesyntax.service;

import core.basesyntax.handler.ShopOperationHandler;
import core.basesyntax.model.Fruit;
import core.basesyntax.strategy.ShopOperationStrategy;
import core.basesyntax.utility.FruitType;
import java.util.List;
import java.util.Map;

public class FruitShopDataProcessorService implements DataProcessorService {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;
    private final ShopOperationStrategy shopOperationStrategy;
    private final Map<FruitType, Fruit> fruitMap;

    public FruitShopDataProcessorService(ShopOperationStrategy shopOperationStrategy,
                                         Map<FruitType, Fruit> fruitMap) {
        this.shopOperationStrategy = shopOperationStrategy;
        this.fruitMap = fruitMap;
    }

    @Override
    public void processData(List<String> data) {
        for (String temp : data) {
            String[] split = temp.split(",");
            ShopOperationHandler shopOperationHandler =
                    shopOperationStrategy.get(split[OPERATION_INDEX]);
            shopOperationHandler.doOperation(fruitMap, split[FRUIT_INDEX],
                    split[QUANTITY_INDEX]);
        }
    }
}
