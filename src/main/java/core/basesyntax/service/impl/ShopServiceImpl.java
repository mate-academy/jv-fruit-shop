package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.stream.IntStream;

public class ShopServiceImpl implements ShopService {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final OperationStrategy activityStrategy;

    public ShopServiceImpl(OperationStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void updateFruitsWarehouse(List<String> dataFruits) {
        IntStream.range(1, dataFruits.size())
                .mapToObj(i -> dataFruits.get(i).split(","))
                .forEach(data -> {
                    Fruit fruit = new Fruit(data[FRUIT_TYPE_INDEX]);
                    activityStrategy.get(data[ACTIVITY_TYPE_INDEX])
                            .apply(fruit, Integer.parseInt(data[QUANTITY_INDEX]));
                });
    }
}
