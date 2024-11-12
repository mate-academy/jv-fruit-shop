package core.basesyntax.services.reportgenerator;

import core.basesyntax.db.DB;

import java.util.Map;
import java.util.Set;

public class ReportGenerator implements IReportGenerator {
    private static final String REPORT_COLUMNS_NAMES = "fruit,quantity";
    private static final String CSV_VALUES_SEPARATOR = ",";

    @Override
    public String getReport() {
        Set<Map.Entry<String, Integer>> fruitEntries = DB.getFruitsDB().entrySet();
        StringBuilder builder = new StringBuilder(REPORT_COLUMNS_NAMES);

        for (Map.Entry<String, Integer> entry : fruitEntries) {
            builder
                    .append("\n")
                    .append(entry.getKey())
                    .append(CSV_VALUES_SEPARATOR)
                    .append(entry.getValue());
        }

        return builder.toString();
    }
}
