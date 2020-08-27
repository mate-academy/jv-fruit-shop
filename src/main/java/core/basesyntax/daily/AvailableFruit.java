package core.basesyntax.daily;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AvailableFruit {

    public static Map<String, Integer> endStock(List<Fruit> list) {
        Map<String, Integer> stockReport = new HashMap<>();
        for (Fruit fruit : list) {
            if (stockReport.containsKey(fruit.getFruit())) {
                stockReport.put(fruit.getFruit(), stockReport.get(fruit.getFruit()) + 1);
            } else {
                stockReport.put(fruit.getFruit(), 1);
            }
        }
        return stockReport;
    }
}
