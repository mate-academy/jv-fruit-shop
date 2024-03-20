package core.basesyntax.service.impl;

import core.basesyntax.service.WriterFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterFileImpl implements WriterFile {
    @Override
    public void writeFile(List<String> report, File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : report) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }
    }
}

