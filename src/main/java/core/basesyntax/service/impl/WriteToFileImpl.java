package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFileImpl implements WriteToFile {
    private static final String dayReportFilePath = "src/main/resources/dayreport.csv";

    @Override
    public void writeToFile(List<String> shiftReport) {
        BufferedWriter startBufferedWriter = null;
        File toFile = new File(dayReportFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile, true))) {
            for (int i = 0; i < shiftReport.size(); i++) {
                bufferedWriter.write(shiftReport.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException("Write error to file " + dayReportFilePath + "!", e);
        }
    }
}
