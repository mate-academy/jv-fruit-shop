package core.basesyntax.db;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeDataToFile(String data, String fileName) {
        File file = new File(fileName);
        try {
            Files.write(file.toPath(), data.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("Unable to create a file " + file, e);
        }
    }
}
