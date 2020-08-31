package core.basesyntax;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AvailableFruit {
    public static Map<String, Long> getStockReport(List<Fruit> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Fruit::getFruitName, Collectors.counting()));
    }
}
