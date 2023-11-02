package core.basesyntax.services;

import core.basesyntax.serviceinterfaces.Writer;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriter implements Writer {
    @Override
    public void writeToFile(String report, String source) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(source))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + source);
        }
    }
}
