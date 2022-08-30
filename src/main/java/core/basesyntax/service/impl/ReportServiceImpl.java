package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            String reportLine = entry.getKey().getName() + "," + entry.getValue()
                    + System.lineSeparator();
            builder.append(reportLine);
        }
        return builder.toString();
    }
}

