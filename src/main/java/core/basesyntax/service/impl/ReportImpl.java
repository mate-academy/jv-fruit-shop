package core.basesyntax.service.impl;

import core.basesyntax.service.Report;
import core.basesyntax.storage.Storage;
import java.util.Map;

public class ReportImpl implements Report {
    @Override
    public String getReport() {
        StringBuilder exitFile = new StringBuilder("Fruit, quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> fruit: Storage.fruitStorage.entrySet()) {
            exitFile.append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        return exitFile.toString();
    }
}
