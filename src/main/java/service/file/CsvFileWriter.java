package service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileWriter implements FileWriter {
    @Override
    public void write(List<String> data, String filePath) {
        File report = new File(filePath);
        try {
            Files.write(Path.of(report.getPath()), data);
        } catch (IOException e) {
            throw new RuntimeException("File cannot bе written - " + filePath);
        }
    }
}
