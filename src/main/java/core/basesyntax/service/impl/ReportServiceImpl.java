package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.servise.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit, quantity";

    @Override
    public String generateReport() {
        StringBuilder stringBuilder = new StringBuilder(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> fruitIntegerEntry: Storage.storageMap.entrySet()) {
            String reportLine = fruitIntegerEntry.getKey().getName() + ","
                    + fruitIntegerEntry.getValue() + System.lineSeparator();
            stringBuilder.append(reportLine);
        }
        return stringBuilder.toString();
    }
}
