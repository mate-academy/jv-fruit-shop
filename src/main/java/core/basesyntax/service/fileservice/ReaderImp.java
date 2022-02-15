package core.basesyntax.service.fileservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderImp implements Reader {
    public List<String> readFromInput(String fileName) {
        List<String> recordActivitiesForDay;
        try {
            recordActivitiesForDay = Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            throw new RuntimeException("Cann`t read file " + fileName, e);
        }
        return recordActivitiesForDay;
    }
}
