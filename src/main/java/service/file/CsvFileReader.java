package service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements FileReader {
    private static final String CSV_CHECK_PATTERN = "^.+\\.csv$";

    @Override
    public List<String> read(String filePath) {
        checkFileFormat(filePath);
        File file = new File(filePath);
        try {
            return Files.readAllLines(Path.of(file.getPath()));
        } catch (IOException e) {
            throw new RuntimeException("Can`t reed file - " + file.getName());
        }
    }

    private void checkFileFormat(String fileName) {
        if (!fileName.matches(CSV_CHECK_PATTERN)) {
            throw new IllegalStateException("Invalid file type, should be .csv but - " + fileName);
        }
    }
}
