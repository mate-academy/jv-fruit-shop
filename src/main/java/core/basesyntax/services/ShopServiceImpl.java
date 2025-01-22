package core.basesyntax.services;

import core.basesyntax.ActivityStrategy;
import core.basesyntax.models.Fruit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    private List<Fruit> fruits = new ArrayList<>();

    private ActivityStrategy activityStrategy;

    public ShopServiceImpl() {
    }

    public ShopServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void process(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    @Override
    public String getReport() {

        StringBuilder report = new StringBuilder();

        Map<String, Integer> reportsOfProducts = new HashMap<>();

        for (Fruit fruit : fruits) {
            if (!reportsOfProducts.containsKey(fruit.getName())) {
                reportsOfProducts.put(fruit.getName(), 0);
            }
            Integer newQuantity = activityStrategy
                    .getActivity(fruit.getType())
                    .apply(fruit.getQuantity(),
                        reportsOfProducts.get(fruit.getName()));
            reportsOfProducts.put(fruit.getName(), newQuantity);
        }

        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : reportsOfProducts.entrySet()) {
            report.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }

        return report.toString();
    }
}
