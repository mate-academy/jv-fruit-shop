package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterToCsvImpl implements Writer {
    private static final String FILE_NAME = File.separator + "reportFile.csv";
    private final String pathFile;

    public WriterToCsvImpl(String filePath) {
        this.pathFile = filePath;
    }

    @Override
    public void writeInFile(List<String> lines) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile + FILE_NAME))) {
            for (String line : lines) {
                writer.write(line + '\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write file to path: " + pathFile, e);
        }
    }
}
