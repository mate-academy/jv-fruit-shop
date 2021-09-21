package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    @Override
    public String createReport(Map<Fruit, Integer> fruitStorageMap, String reportName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(reportName);
        for (Map.Entry<Fruit, Integer> entry : fruitStorageMap.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(", ")
                    .append(entry.getValue());
        }
        return stringBuilder.append(System.lineSeparator()).toString();
    }
}
