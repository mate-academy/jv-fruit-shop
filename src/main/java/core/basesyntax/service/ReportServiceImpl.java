package core.basesyntax.service;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    @Override
    public String getReport() {
        StringBuilder content = new StringBuilder();
        content.append("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            content.append("\n").append(entry.getKey().getName())
                    .append(",").append(entry.getValue());

        }
        return content.toString();
    }
}
