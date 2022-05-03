package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public boolean write(String report, String filePath) {
        try {
            Files.writeString(Paths.get(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file in ReportWriter in " + filePath, e);
        }
        return true;
    }
}
