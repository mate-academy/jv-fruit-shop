package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImplService implements ReportService {
    private static final String SEPARATOR = ",";

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : DataBase.mapDb.entrySet()) {
            builder.append(entry.getKey())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
