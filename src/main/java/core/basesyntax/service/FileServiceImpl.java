package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    private static final String REPORT_FILE_NAME = "reportfile.csv";

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> operations;
        try {
            operations = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file" + filePath);
        }
        return operations;
    }

    @Override
    public void writeToFile(String data, String fileName) {
        File reportFile = new File(fileName);
        Path filePath = reportFile.toPath();

        try {
            boolean newFile = reportFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file" + fileName);
        }

        try {
            Files.write(filePath, data.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file" + fileName);
        }
    }
}
