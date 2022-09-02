package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.CreatReportService;
import java.util.Map;

public class CreatReportServiceImpl implements CreatReportService {
    private static final String HEADER_QUANTITY = "quantity";
    private static final String HEADER_FRUIT = "fruit";

    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER_FRUIT).append(",").append(HEADER_QUANTITY)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
