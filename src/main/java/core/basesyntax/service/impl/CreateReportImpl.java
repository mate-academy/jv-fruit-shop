package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CreateReport;
import java.util.Map;

public class CreateReportImpl implements CreateReport {
    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> map : Storage.storageFruits.entrySet()) {
            report.append(map.getKey())
                    .append(",")
                    .append(map.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
