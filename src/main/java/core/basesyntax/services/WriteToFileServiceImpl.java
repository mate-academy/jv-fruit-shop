package core.basesyntax.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class WriteToFileServiceImpl implements WriteToFileService {
    private static final String TITLE_STRING_OF_FILE = "fruit,quantity";

    @Override
    public void putDbToFile(Map<String, Integer> dayResult, String fileName) {
        File file = new File(fileName);
        String text = TITLE_STRING_OF_FILE + System.lineSeparator();
        try {
            Files.write(file.toPath(), text.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write BD to to file" + fileName, e);
        }
        for (Map.Entry<String, Integer> entry:dayResult.entrySet()) {
            text = entry.getKey() + " " + entry.getValue() + System.lineSeparator();
            try {
                Files.write(file.toPath(), text.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write BD to to file" + fileName, e);
            }
        }
    }
}
