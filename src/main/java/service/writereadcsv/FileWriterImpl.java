package service.writereadcsv;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFileCsv(String report, String fileToPath) {
        try {
            Files.write(Path.of(fileToPath), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + fileToPath, e);
        }
    }
}
