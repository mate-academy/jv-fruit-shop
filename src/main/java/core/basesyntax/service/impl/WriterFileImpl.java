package core.basesyntax.service.impl;

import core.basesyntax.service.WriterFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterFileImpl implements WriterFile {
    private static final String OUTPUT_FILE_NAME = "src/main/resources/report.csv";

    @Override
    public void writeToFile(String report) {
        try (FileWriter writer = new FileWriter(OUTPUT_FILE_NAME);
                BufferedWriter bwr = new BufferedWriter(writer)) {
            bwr.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file " + OUTPUT_FILE_NAME);
        }
    }
}
