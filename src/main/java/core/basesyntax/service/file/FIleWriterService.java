package core.basesyntax.service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FIleWriterService {
    public static void writeToFile(File file, String data) {
        try {
            Files.write(file.toPath(), data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file by path: " + file.getPath(), e);
        }

    }
}
