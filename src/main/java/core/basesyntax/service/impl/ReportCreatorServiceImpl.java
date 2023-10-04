package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.ReportCreatorService;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    private static final String HEAD = "fruit,quantity";
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(HEAD);
        for (Map.Entry<String, Integer> line : FruitStorage.fruitStorage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(line.getKey())
                    .append(SEPARATOR)
                    .append(line.getValue());
        }
        return report.toString();
    }
}
