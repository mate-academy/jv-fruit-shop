package core.basesyntax.service.impls;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportCreator;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String getReport() {
        if (Storage.shopDatabase.isEmpty()) {
            return "";
        }

        StringBuilder reportBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : Storage.shopDatabase.entrySet()) {
            reportBuilder.append(String.valueOf(entry.getKey()))
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return reportBuilder.toString();
    }
}
