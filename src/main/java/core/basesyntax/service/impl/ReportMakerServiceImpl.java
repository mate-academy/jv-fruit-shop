package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMakerService;
import java.util.Map;

public class ReportMakerServiceImpl implements ReportMakerService {
    private static final String FIRST_LINE = "fruits,quantity" + System.lineSeparator();
    private static final String COMMA = ",";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder(FIRST_LINE);
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
