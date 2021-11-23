package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import java.io.FileWriter;

public class ReportServiceImpl implements ReportService {

    @Override
    public String getReportText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        Storage.getStore().entrySet()
                .stream().forEach(kv -> stringBuilder
                .append(kv.getKey().getName())
                .append(",")
                .append(kv.getValue())
                .append(System.lineSeparator()));
        return stringBuilder.toString();
    }

    @Override
    public void writeReport(String report, String fileName) {
        try {
            FileWriter output = new FileWriter(fileName);
            output.write(report);
            output.close();
        } catch (Exception e) {
            throw new RuntimeException("Can't write report file!", e);
        }
    }
}
