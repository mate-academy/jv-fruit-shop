package core.basesyntax.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    @Override
    public void createReport(String report, String path) {
        File file = new File(path);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("We can't write to file " + path, e);
        }
    }
}
