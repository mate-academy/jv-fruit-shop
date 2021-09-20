package core.basesyntax.service.minorservices;

import core.basesyntax.database.FruitsStorage;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    private static final String FRUIT_COLUMN = "fruit";
    private static final String QUANTITY_COLUMN = "quantity";

    @Override
    public String writeReport() {
        StringBuilder report = new StringBuilder();
        report.append(FRUIT_COLUMN).append(",").append(QUANTITY_COLUMN)
                .append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : FruitsStorage.fruitsStorage.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString().trim();
    }
}
