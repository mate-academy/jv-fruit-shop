package core.basesyntax.serviceImpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry key : Storage.fruits.entrySet()) {
            builder.append(key.getKey().toString())
                    .append(",")
                    .append(key.getValue().toString())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
