package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.io.FileWriter;

public class ReportServiceImpl implements ReportService {

    @Override
    public String getReportText() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        Storage.getStore().stream().forEach(fr -> stringBuilder
                .append(fr.getName())
                .append(",")
                .append(fr.getCount())
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
