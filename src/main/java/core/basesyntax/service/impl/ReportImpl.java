package core.basesyntax.service.impl;

import core.basesyntax.service.Report;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportImpl implements Report {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("Fruit, quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> fruit: Storage.fruitStorage.entrySet()) {
            report.append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
