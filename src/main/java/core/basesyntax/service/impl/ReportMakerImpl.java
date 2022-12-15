package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportMaker;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    @Override
    public String createReport() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit").append(",").append("quantity");
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey()).append(",").append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
