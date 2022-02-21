package core.basesyntax.service;

import core.basesyntax.storage.DataStorage;
import java.util.Map;

public class CreateReportImpl implements CreateReport {
    private static final String COMA_SEPARATOR = ",";
    private static final String TITLE = "fruit,quantity";

    private StringBuilder reportBuilder = new StringBuilder();

    public String report() {
        reportBuilder.append(TITLE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> m: DataStorage.fruitMap.entrySet()) {
            reportBuilder.append(m.getKey())
                    .append(COMA_SEPARATOR).append(m.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
