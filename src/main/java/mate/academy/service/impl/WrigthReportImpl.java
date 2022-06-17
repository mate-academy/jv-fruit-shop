package mate.academy.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import mate.academy.service.WrigthReport;

public class WrigthReportImpl implements WrigthReport {

    @Override
    public void wrigthReport(String pathName, String reportRecords) {
        final File toFile = new File(pathName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(reportRecords);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to: " + pathName, e);
        }
    }
}
