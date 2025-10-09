package core.basesyntax.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ReportGeneratorImpl implements ReportGenerator {
    private final Map<String, Integer> stock;

    public ReportGeneratorImpl(Map<String, Integer> stock) {
        if (stock == null) {
            throw new RuntimeException("Stock map for ReportGeneratorImpl is null");
        }
        this.stock = Collections.unmodifiableMap(new HashMap<>(stock));
    }

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity\n");
        new TreeMap<>(stock)
                .forEach((fruit, qty) -> sb.append(fruit).append(",").append(qty).append("\n"));
        return sb.toString();
    }
}
