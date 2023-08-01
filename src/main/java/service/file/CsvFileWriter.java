package service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileWriter implements FileWriter {
    public static final String FILE_PATH = "src\\main\\resources\\Report.csv";

    @Override
    public void write(List<String> data) {
        File report = new File(FILE_PATH);
        try {
            Files.write(Path.of(report.getPath()), data);
        } catch (IOException e) {
            throw new RuntimeException("File cannot by written");
        }
    }
}
