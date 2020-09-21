package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Storage {
    private Map<String, List<DateAndQuantity>> storage = new HashMap<>();

    public Map<String, List<DateAndQuantity>> getAllProducts() {
        return storage;
    }

    public void addProductBox(String productName, List<DateAndQuantity> productList) {
        storage.put(productName, productList);
    }

    public void removeProductBox(String productName, List<DateAndQuantity> productList) {
        storage.remove(productName);
    }

    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        Set<String> keys = storage.keySet();
        String[] keysArray = keys.toArray(new String[0]);
        for (String s : keysArray) {
            int totalAmount = 0;
            for (int j = 0; j < storage.get(s).size(); j++) {
                totalAmount = totalAmount + storage.get(s).get(j).getQuantity();
            }
            report.append("\n").append(s).append(",").append(totalAmount);
        }
        return report.append("\n").toString();
    }
}
