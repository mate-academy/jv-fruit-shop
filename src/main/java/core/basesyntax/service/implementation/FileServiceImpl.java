package core.basesyntax.service.implementation;

import core.basesyntax.service.FileService;
import core.basesyntax.validator.DataValidator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileServiceImpl implements FileService {
    private static final String TO_FILE_PATH = "src/main/resources/Report.csv";
    private static DataValidator dataValidator;

    public FileServiceImpl() {
        dataValidator = new DataValidator();
    }

    @Override
    public List<String> readFromFile(String fromFileName) {
        File newFile = new File(fromFileName);
        try {
            return Files.readAllLines(newFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("File doesn't exist " + e);
        }
    }

    @Override
    public void writeDataToFile(String report) {
        File toFile = new File(TO_FILE_PATH);
        try (FileWriter fileWriter = new FileWriter(toFile)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong " + e);
        }
    }
}
