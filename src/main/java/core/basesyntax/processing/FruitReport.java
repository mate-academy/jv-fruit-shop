package core.basesyntax.processing;

import java.util.Map;

public class FruitReport {
    private static final String SEPARATOR = System.lineSeparator();

    public String getFruitReport(Map<String, Integer> storage) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity");
        storage.entrySet()
                .forEach(i -> builder.append(SEPARATOR)
                        .append(i.getKey())
                        .append(",")
                        .append(i.getValue()));
        return builder.toString();
    }
}
