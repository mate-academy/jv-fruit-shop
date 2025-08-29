package basesyntax.serviceimpl;

import basesyntax.db.Storage;
import basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.TreeMap;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEADER = "fruit,quantity";
    private static final String KOMMA = ",";

    @Override
    public String getReport() {
        Map<String, Integer> fruitStocks = new TreeMap<>(Storage.getFruits());
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(REPORT_HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitStocks.entrySet()) {
            reportBuilder.append(entry.getKey()).append(KOMMA)
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
