package core.basesyntax.service.minorservices;

import core.basesyntax.database.FruitsStorage;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    private static final String HEAD_ROW = "fruit,quantity";

    @Override
    public String writeReport() {
        StringBuilder report = new StringBuilder();
        report.append(HEAD_ROW).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : FruitsStorage.fruitsStorage.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
