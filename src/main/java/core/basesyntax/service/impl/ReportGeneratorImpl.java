package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String generateReport() {
        String header = "fruit,quantity";
        StringBuilder sb = new StringBuilder();
        sb.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.fruitStorage.entrySet()) {
            String fruit = entry.getKey();
            Integer quantity = entry.getValue();
            sb.append(System.lineSeparator() + fruit + "," + quantity);
        }
        return sb.toString();
    }
}
