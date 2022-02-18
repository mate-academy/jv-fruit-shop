package core.basesyntax.service.fileservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderImpl implements Reader {
    public List<String> readFromInput(String fileName) {
        List<String> recordActivitiesForDay;
        try {
            recordActivitiesForDay = Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Cann`t read file " + fileName, e);
        }
        if (recordActivitiesForDay.isEmpty()) {
            throw new RuntimeException("The contents of the file cannot be empty");
        }
        return recordActivitiesForDay;
    }
}
