package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DaoWriterImpl implements DaoWriter {
    @Override
    public void write(List<String> stringReport, String fileName) {
        try {
            Files.write(Path.of(fileName), stringReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write the file: " + fileName);
        }
    }
}
