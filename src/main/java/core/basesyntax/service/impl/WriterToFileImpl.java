package core.basesyntax.service.impl;

import core.basesyntax.service.WriterToFile;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterToFileImpl implements WriterToFile {
    @Override
    public void writeReportToFile(String report, String toFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(toFileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
