package core.basesyntax.service;

import core.basesyntax.controller.ControllerDaoImpl;
import core.basesyntax.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ReportCreator {
    public List<String[]> createReport() {
        List<String[]> report = new ArrayList<>();
        report.add(new String[]{"fruit", "quantity"});
        Map<String, Integer> countMap = countProducts();
        for (String s : countMap.keySet()) {
            report.add(new String[]{s, String.valueOf(countMap.get(s))});
        }
        return report;
    }

    private Map<String, Integer> countProducts() {
        Map<String, Integer> countMap = new TreeMap<>();
        List<Product> storageList = new ControllerDaoImpl().getAll();
        for (Product product : storageList) {
            if (countMap.containsKey(product.getFruitType())) {
                countMap.replace(product.getFruitType(), countMap.get(product.getFruitType()) + 1);
            } else {
                countMap.put(product.getFruitType(), 1);
            }
        }
        return countMap;
    }
}
