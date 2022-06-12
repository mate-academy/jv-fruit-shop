package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey().getName())
                    .append(",").append(entry.getValue());
        }
        return reportBuilder.toString();
    }
}
