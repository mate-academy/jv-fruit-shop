package core.basesyntax.services;

import core.basesyntax.ActivityStrategy;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.models.Fruit;
import java.util.HashMap;
import java.util.Map;

public class DataProcessorImpl implements DataProcessor {
    private final ActivityStrategy activityStrategy;
    private final FruitDao fruitDao;

    public DataProcessorImpl(ActivityStrategy activityStrategy, FruitDao fruitDao) {
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitDao;
    }

    @Override
    public Map<String, Integer> process() {
        Map<String, Integer> reportsOfProducts = new HashMap<>();
        for (Fruit fruit : fruitDao.getAll()) {
            reportsOfProducts.putIfAbsent(fruit.getName(), 0);
            Integer newQuantity = activityStrategy
                    .getActivity(fruit.getType())
                    .apply(reportsOfProducts.get(fruit.getName()), fruit.getQuantity());

            reportsOfProducts.put(fruit.getName(), newQuantity);
        }
        return reportsOfProducts;
    }
}
