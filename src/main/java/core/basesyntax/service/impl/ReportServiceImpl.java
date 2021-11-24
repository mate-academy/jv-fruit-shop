package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String formReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            report.append(entry.getKey().getName()).append(",")
                    .append(entry.getValue()).append("\n");
        }
        return report.toString();
    }
}
