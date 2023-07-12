package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriterImpl implements DataWriter {
    @Override
    public void writeData(String fileReport, String dataReports) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileReport))) {
            writer.write(dataReports);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file"
                    + fileReport, e);
        }
    }
}
