package core.basesyntax.dao.impl;

import core.basesyntax.dao.WriteDataToFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteDataToFileImpl implements WriteDataToFile {
    @Override
    public void writeDataToFile(String report, String path) {
        File file = new File(path);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cant write content to file " + e);
        }
    }
}
