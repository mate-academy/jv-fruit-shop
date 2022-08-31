package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteToFileImpl implements Writer {
    @Override
    public void writeToFile(String fileName, String report) {
        try {
            Files.write(new File(fileName).toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName + " " + e);
        }
    }
}
