package core.basesyntax.service.implementation;

import core.basesyntax.service.FileService;
import core.basesyntax.validator.DataValidator;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

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
            List<String> dataFromFile = Files.readAllLines(newFile.toPath())
                    .stream()
                    .map(string -> string
                            .replaceAll("\\s", ""))
                    .collect(Collectors.toList());
            dataValidator.validate(dataFromFile);
            return dataFromFile;
        } catch (IOException e) {
            throw new RuntimeException("File doesn't exist " + e);
        }
    }

    @Override
    public void createReportFile(String report) {
        File toFile = new File(TO_FILE_PATH);
        try (FileWriter fileWriter = new FileWriter(toFile)) {
            fileWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong " + e);
        }
    }
}
