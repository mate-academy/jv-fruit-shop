package core.basesyntax.service.impl;

import core.basesyntax.data.Storage;
import core.basesyntax.service.FruitService;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String HEAD_LINE = "fruit,quantity";

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder(HEAD_LINE);
        for (Map.Entry<String, Integer> line : Storage.storage.entrySet()) {
            report.append(System.lineSeparator())
                    .append(line.getKey())
                    .append(",")
                    .append(line.getValue());
        }
        return report.toString();
    }
}
