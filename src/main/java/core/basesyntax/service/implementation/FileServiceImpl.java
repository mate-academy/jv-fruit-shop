package core.basesyntax.service.implementation;

import core.basesyntax.service.FileService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileServiceImpl implements FileService {
    private static final String TO_FILE_PATH = "src/main/resources/Report.csv";
    
    @Override
    public List<String> readFromFile(String fromFilePath) {
        File newFile = new File(fromFilePath);
        try {
            return Files.readAllLines(newFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path " + fromFilePath, e);
        }
    }

    @Override
    public void writeDataToFile(String report) {
        File toFile = new File(TO_FILE_PATH);
        try (FileWriter fileWriter = new FileWriter(toFile)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path" + TO_FILE_PATH, e);
        }
    }
}
