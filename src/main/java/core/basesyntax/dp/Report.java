package core.basesyntax.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Report {
    private static Map<String, Integer> fruitsQuantity = new HashMap<>();

    public static String getReport() {
        return fruitsQuantity.entrySet().stream()
                .map(totalFruits -> totalFruits.getKey() + "," + totalFruits.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
    }

    public static Map<String, Integer> getFruitsQuantity() {
        return fruitsQuantity;
    }

    public static void setFruitsQuantity(Map<String, Integer> fruitsQuantity) {
        Report.fruitsQuantity = fruitsQuantity;
    }
}
