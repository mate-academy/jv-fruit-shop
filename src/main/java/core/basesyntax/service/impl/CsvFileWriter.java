package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class CsvFileWriter implements FileWriter {
    @Override
    public void writeReport(String targetFileName, List<String> report) {
        try {
            File reportFile = new File(targetFileName);
            reportFile.createNewFile();
            BufferedWriter reportWriter = new BufferedWriter(new java.io.FileWriter(reportFile));
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
