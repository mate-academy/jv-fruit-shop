package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.fruitStorage;

import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitStorage.entrySet()) {
            stringBuilder.append("\n" + entry.getKey() + "," + entry.getValue());
        }
        return stringBuilder.toString();
    }
}
