package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterImpl implements ReportWriter {

    @Override
    public void writeReport(String reportName, List<String> reportText) {
        String defaultText = "fruit,quantity" + System.lineSeparator();
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(
                                     "src/main/resources/reports/" + reportName))) {
            bufferedWriter.write(defaultText);
            for (String reportLine : reportText) {
                bufferedWriter.write(reportLine);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write this file: " + reportName, e);
        }
    }
}
