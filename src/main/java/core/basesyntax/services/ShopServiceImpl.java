package core.basesyntax.services;

import core.basesyntax.ActivityStrategy;
import core.basesyntax.models.Product;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    private List<Product> products = new ArrayList<>();

    private ActivityStrategy activityStrategy;

    public ShopServiceImpl() {
    }

    public ShopServiceImpl(ActivityStrategy activityStrategy) {
        this.activityStrategy = activityStrategy;
    }

    @Override
    public void process(List<Product> products) {
        this.products = products;
    }

    @Override
    public String getReport() {

        StringBuilder report = new StringBuilder();

        Map<String, Integer> reportsOfProducts = new HashMap<>();

        for (Product product : products) {
            if (!reportsOfProducts.containsKey(product.getName())) {
                reportsOfProducts.put(product.getName(), 0);
            }
            Integer newQuantity = activityStrategy
                    .getActivity(product.getType())
                    .apply(product.getQuantity(),
                        reportsOfProducts.get(product.getName()));
            reportsOfProducts.put(product.getName(), newQuantity);
        }

        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : reportsOfProducts.entrySet()) {
            report.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }

        return report.toString();
    }
}
