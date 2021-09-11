package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import validator.Validator;
import validator.ValidatorImp;

public class ReaderServiceImp implements ReaderService {
    private Validator validator = new ValidatorImp();

    @Override
    public List<String> readFromFile(String filePath) {
        List<String> activitiesLines;
        try {
            activitiesLines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from the file!", e);
        }
        return activitiesLines.stream()
                .filter(line -> validator.validationReportLine(line))
                .collect(Collectors.toList());
    }
}
