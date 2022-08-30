package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void writeToFile(String fileName, String report) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + fileName + " " + e);
        }
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName + " " + e);
        }
    }
}
