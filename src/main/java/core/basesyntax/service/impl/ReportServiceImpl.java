package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String START_MESSAGE = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String getReport() {
        StringBuilder builder = new StringBuilder()
                .append(START_MESSAGE)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> position : Storage.storage.entrySet()) {
            builder.append(position.getKey().getName())
                    .append(COMMA)
                    .append(position.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
