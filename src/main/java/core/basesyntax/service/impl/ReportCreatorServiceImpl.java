package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportCreatorServiceImpl implements ReportCreatorService {
    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity \n");
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            reportBuilder.append(entry.getKey().getName())
                    .append(",")
                    .append(entry.getValue())
                    .append('\n');
        }
        return reportBuilder.toString();
    }
}
