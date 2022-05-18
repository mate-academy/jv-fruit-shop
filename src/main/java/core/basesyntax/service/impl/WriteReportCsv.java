package core.basesyntax.service.impl;

import core.basesyntax.service.WriteReport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteReportCsv implements WriteReport {
    @Override
    public void outReport(String report, String destination) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destination));
            bufferedWriter.write(report);
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to the file " + destination, e);
        }
    }
}
