package core.basesyntax.service;

import core.basesyntax.Product;
import core.basesyntax.Storage;
import java.util.HashMap;
import java.util.Map;

public class Report {
    private Storage storage;

    public Report(Storage storage) {
        this.storage = storage;
    }

    public String makeReport() {
        Map<String, Integer> fruitMap = new HashMap<>();
        for (int i = 0; i < storage.getFruitList().size(); i++) {
            Product product = storage.getFruitList().get(i);
            if (fruitMap.containsKey(product.getProductName())) {
                fruitMap.put(product.getProductName(),
                        fruitMap.get(product.getProductName()) + product.getCount());
            } else {
                fruitMap.put(product.getProductName(), product.getCount());
            }
        }

        StringBuilder result = new StringBuilder("fruit,quantity\r");
        for (String key : fruitMap.keySet()) {
            result.append(key)
                    .append(",")
                    .append(fruitMap.get(key))
                    .append("\r");
        }

        return result.toString();
    }
}
