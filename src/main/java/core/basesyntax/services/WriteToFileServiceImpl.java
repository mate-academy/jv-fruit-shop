package core.basesyntax.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteToFileServiceImpl implements WriteToFileService {
    private static final String TITLE_STRING_OF_FILE = "fruit,quantity";

    @Override
    public void writeToFile(String report, String fileName) {
        File file = new File(fileName);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write BD to to file" + fileName, e);
        }
    }
}
