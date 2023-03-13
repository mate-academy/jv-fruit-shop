package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder(HEADER);
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            builder.append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
