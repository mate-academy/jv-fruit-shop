package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportMaker;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    @Override
    public String createReport() {
        StringBuilder result = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
            result.append(System.lineSeparator()).append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return result.toString();
    }
}
