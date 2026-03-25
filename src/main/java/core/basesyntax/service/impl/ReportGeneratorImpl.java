package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport() {
        Map<String, Integer> fruits = Storage.getAll();

        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            sb.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append("\n");
        }

        return sb.toString();
    }
}

