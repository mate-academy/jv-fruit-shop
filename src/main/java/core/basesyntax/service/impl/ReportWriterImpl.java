package core.basesyntax.service.impl;

import core.basesyntax.service.ReportWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ReportWriterImpl implements ReportWriter {
    @Override
    public void writeReport(String targetFileName, List<String> report) {
        try {
            File reportFile = new File(targetFileName);
            reportFile.createNewFile();
            BufferedWriter reportWriter = new BufferedWriter(new FileWriter(reportFile));
            for (String reportLine : report) {
                reportWriter.write(reportLine);
                reportWriter.flush();
            }
            reportWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to file: " + targetFileName, e);
        }
    }
}
