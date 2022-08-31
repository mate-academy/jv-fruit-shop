package core.basesyntax.service.impl;

import core.basesyntax.model.FruitType;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String REGEX = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(HEADER)
                .append(System.lineSeparator());
        for (FruitType fruits : Storage.getStorage().keySet()) {
            stringBuilder.append(fruits.toString().toLowerCase())
                    .append(REGEX)
                    .append(Storage.getStorage().get(fruits))
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
