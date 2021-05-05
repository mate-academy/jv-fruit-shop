package core.basesyntax.service.workwithfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {

    @Override
    public void writeData(String report, String path) {
        File file = new File(path);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
