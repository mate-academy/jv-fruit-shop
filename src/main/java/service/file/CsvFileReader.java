package service.file;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvFileReader implements FileReader {
    private static final String CSV_CHECK_PATTERN = "^.+\\.csv$";

    @Override
    public List<String> read(String fileName) {
        checkFileFormat(fileName);
        File file = getFileFromResources(fileName);
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

    private File getFileFromResources(String fileName) {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        String filePath = classLoader.getResource(fileName).getFile();
        if (filePath == null) {
            throw new NullPointerException("File not found - " + fileName);
        }
        return new File(filePath);
    }
}
