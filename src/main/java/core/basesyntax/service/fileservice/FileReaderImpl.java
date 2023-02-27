package core.basesyntax.service.fileservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    public static final String FILE_FORMAT = "csv";
    public static final int SEPARATOR_INDEX = 1;

    public List<String> read(String fileName) {
        checkFileName(fileName);
        List<String> activitiesForDay;
        try {
            activitiesForDay = Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can`t read file " + fileName, e);
        }
        if (activitiesForDay.isEmpty()) {
            throw new RuntimeException("File cannot be empty");
        }
        return activitiesForDay;
    }

    private void checkFileName(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            throw new RuntimeException("Wrong file name" + fileName);
        }
        if (!fileName.split("\\.")[SEPARATOR_INDEX].equals(FILE_FORMAT)) {
            throw new RuntimeException("Wrong file format. Expected CSV file");
        }
    }
}
