package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String REGEX = ",";

    @Override
    public String getReport() {
        StringBuilder stringBuilder = new StringBuilder()
                .append(HEADER)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> map : Storage.getStorage().entrySet()) {
            stringBuilder.append(map.getKey().getName())
                    .append(REGEX)
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
