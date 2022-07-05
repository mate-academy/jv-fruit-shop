package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeToFile(String dayReportFilePath, List<String> shiftReport) {
        BufferedWriter startBufferedWriter = null;
        File toFile = new File(dayReportFilePath);
        try (BufferedWriter bufferedWriter
                    = new BufferedWriter(new java.io.FileWriter(toFile, true))) {
            for (int i = 0; i < shiftReport.size(); i++) {
                bufferedWriter.write(shiftReport.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException("Write error to file " + dayReportFilePath + "!", e);
        }
    }
}
