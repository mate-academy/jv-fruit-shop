package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public String formReport() {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : Storage.fruitStorage.entrySet()) {
            report.append(entry.getKey().getName()).append(",")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }
}
