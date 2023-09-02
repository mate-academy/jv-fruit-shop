package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportService {

    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity");

        for (Map.Entry<String, Integer> entry : Storage.DB.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(",")
                    .append(entry.getValue());
        }

        return reportBuilder.toString();
    }
}

