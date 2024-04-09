package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import service.FileWriterService;

public class ReportWriterService implements FileWriterService {
    private static final String HEADER_LINE = "fruit,quantity";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public void writeToFile(List<String> fruitsBalanceReport) {
        File report = new ReportFileCreatorImpl().createFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(report))) {
            writer.write(HEADER_LINE);
            for (String lineToWrite : fruitsBalanceReport) {
                writer.write(LINE_SEPARATOR + lineToWrite);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + report, e);
        }
    }
}
