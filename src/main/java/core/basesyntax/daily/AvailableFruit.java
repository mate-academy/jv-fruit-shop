package core.basesyntax.daily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvailableFruit {

    public static Map<String, Integer> getStockReport(List<Fruit> list) {
        Map<String, Integer> stockReport = new HashMap<>();
        for (Fruit fruit : list) {
            if (stockReport.containsKey(fruit.getFruitName())) {
                stockReport.put(fruit.getFruitName(), stockReport.get(fruit.getFruitName()) + 1);
            } else {
                stockReport.put(fruit.getFruitName(), 1);
            }
        }
        return stockReport;
    }
}
