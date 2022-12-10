package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit, quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public String createReport() {
        StringBuilder reportBuilder = new StringBuilder(HEADER).append(LINE_SEPARATOR);
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry : Storage.storageMap.entrySet()) {
            String reportLine = fruitIntegerEntry.getKey().getName()
                    + "," + fruitIntegerEntry.getValue()
                    + LINE_SEPARATOR;
            reportBuilder.append(reportLine);
        }
        return reportBuilder.toString();
    }
}
