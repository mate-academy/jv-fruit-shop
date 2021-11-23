package core.basesyntax.service.report;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String HEAD_OF_REPORT = "fruit,quantity";
    private static final String COMMA = ",";

    @Override
    public String formReport() {
        StringBuilder reportBuilder = new StringBuilder(HEAD_OF_REPORT);
        for (Map.Entry<String, Fruit> entry : Storage.fruitStorage.entrySet()) {
            reportBuilder.append(System.lineSeparator())
                    .append(entry.getKey())
                    .append(COMMA)
                    .append(entry.getValue().getQuantity());
        }
        return reportBuilder.toString();
    }
}
