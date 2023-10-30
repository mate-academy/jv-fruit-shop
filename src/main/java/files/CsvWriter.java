package files;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class CsvWriter implements Writer{
    @Override
    public void writeIntoFile(Path path, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile()))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data into the file" + path.getFileName());
        }
    }
}
