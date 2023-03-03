package core.basesyntax.service.fileservice;

import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileReaderImpl implements FileReader {
    private final Validator validator;

    public FileReaderImpl() {
        this.validator = new ValidatorImpl();
    }

    public List<String> read(String fileName) {
        validator.checkFileName(fileName);
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
}
