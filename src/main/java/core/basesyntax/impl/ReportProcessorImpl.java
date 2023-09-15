package core.basesyntax.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportProcessor;

import java.util.Map;

public class ReportProcessorImpl implements ReportProcessor {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String,Integer> entry : Storage.STORAGE.entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append(System.lineSeparator());
        }
        return report.toString();
    }

}
