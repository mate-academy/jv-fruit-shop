package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String reportName) {
        String defaultText = "fruit,quantity" + System.lineSeparator();
        List<String> reportList = Storage.STORAGE
                .entrySet()
                .stream()
                .map(stringIntegerEntry -> stringIntegerEntry.getKey() + ","
                        + stringIntegerEntry.getValue() + System.lineSeparator())
                .toList();

        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(
                                     "src/main/resources/reports/" + reportName))) {
            bufferedWriter.write(defaultText);
            for (String reportLine : reportList) {
                bufferedWriter.write(reportLine);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write this file: " + reportName, e);
        }
    }
}
