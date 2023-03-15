package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class WriterServiceCsv implements WriterService<String, File> {
    @Override
    public void writeLines(Collection<String> data, File target) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(target))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("IOException while writing to file " + target.getName());
        }
    }
}
