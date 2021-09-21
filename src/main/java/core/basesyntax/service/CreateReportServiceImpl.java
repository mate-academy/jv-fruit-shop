package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    @Override
    public String createReport(Map<Fruit, Integer> fruitStorageMap, String reportName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : fruitStorageMap.entrySet()) {
            stringBuilder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
