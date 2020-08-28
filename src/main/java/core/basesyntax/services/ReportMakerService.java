package core.basesyntax.services;

import core.basesyntax.ProductBox;
import core.basesyntax.Storage;
import java.util.HashMap;
import java.util.Map;

public class ReportMakerService {
    private Storage storage;

    public ReportMakerService(Storage storage) {
        this.storage = storage;
    }

    public String makeReport() {
        Map<String, Integer> fruitMap = new HashMap<>();
        for (int i = 0; i < storage.getFruitSupplies().size(); i++) {
            ProductBox productBox = storage.getFruitSupplies().get(i);
            if (fruitMap.containsKey(productBox.getProductName())) {
                fruitMap.put(productBox.getProductName(),
                        fruitMap.get(productBox.getProductName()) + productBox.getCount());
            } else {
                fruitMap.put(productBox.getProductName(), productBox.getCount());
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
