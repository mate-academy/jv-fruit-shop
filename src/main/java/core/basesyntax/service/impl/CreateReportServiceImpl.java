package core.basesyntax.service.impl;

import core.basesyntax.db.FruitStorage;
import core.basesyntax.service.CreateReportService;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TITLE = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder validStringData = new StringBuilder();

        validStringData.append(TITLE + System.lineSeparator());

        for (Map.Entry<String, Integer> entry : FruitStorage.fruitsStorage.entrySet()) {
            validStringData.append(entry.getKey() + ",");
            validStringData.append(entry.getValue() + System.lineSeparator());
        }

        return validStringData.toString();
    }
}
