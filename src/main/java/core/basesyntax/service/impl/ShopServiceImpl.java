package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.ActivityStrategy;
import java.util.List;
import java.util.stream.IntStream;

public class ShopServiceImpl implements ShopService {
    private static final int ACTIVITY_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private final ActivityStrategy activityStrategy;
    private final FruitStorageDao fruitDao;

    public ShopServiceImpl(ActivityStrategy activityStrategy, FruitStorageDao fruitStorageDao) {
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitStorageDao;
    }

    @Override
    public List<Fruit> updateShopWarehouse(List<String> csvData) {
        IntStream.range(1, csvData.size())
                .mapToObj(i -> csvData.get(i).split(","))
                .forEach(data -> activityStrategy.get(data[ACTIVITY_TYPE_INDEX])
                        .apply(data[FRUIT_TYPE_INDEX], Integer.parseInt(data[QUANTITY_INDEX])));
        return fruitDao.getAll();
    }
}
