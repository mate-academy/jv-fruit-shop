package core.basesyntax.services;

import core.basesyntax.ActivityStrategy;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.models.Product;
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
        for (Product product : fruitDao.getAll()) {
            reportsOfProducts.putIfAbsent(product.getName(), 0);
            Integer newQuantity = activityStrategy
                    .getActivity(product.getType())
                    .apply(reportsOfProducts.get(product.getName()), product.getQuantity());

            reportsOfProducts.put(product.getName(), newQuantity);
        }
        return reportsOfProducts;
    }
}
