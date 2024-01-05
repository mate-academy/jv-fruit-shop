package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterOwn;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FileWriterOwn<String> {
    private static final String REPORT_FILE_NAME = "report.csv";

    @Override
    public void write(List<String> data) {
        File file = new File(REPORT_FILE_NAME);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
