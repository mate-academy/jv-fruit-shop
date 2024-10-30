package core.basesyntax.report;

import java.util.Map;

public class FruitReportServiceImpl implements FruitReportService {
    private final Map<String, Integer> fruitStorage;

    public FruitReportServiceImpl(Map<String, Integer> fruitStorage) {
        this.fruitStorage = fruitStorage;
    }

    @Override
    public String getReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            reportBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }

        return reportBuilder.toString();
    }
}
