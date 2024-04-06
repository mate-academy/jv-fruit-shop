package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.service.CreateReport;
import java.util.Map;

public class ReportServiceImpl implements CreateReport {
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
        System.out.println(builder);
        return builder.toString();
    }
}
