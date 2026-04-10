package core.basesyntax.service;

import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {

    private final Map<String, Integer> storage;

    public ReportGeneratorImpl(Map<String, Integer> storage) {
        this.storage = storage;
    }

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> e : storage.entrySet()) {
            sb.append(e.getKey())
                    .append(",")
                    .append(e.getValue())
                    .append("\n");
        }

        return sb.toString();
    }
}
