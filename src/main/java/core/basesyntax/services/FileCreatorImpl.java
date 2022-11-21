package core.basesyntax.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileCreatorImpl implements FileCreator {
    @Override
    public void createFile(String report, String filePath) {
        File file = new File(filePath);
        try {
            Files.writeString(file.toPath(), report);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file "
                    + filePath, e);
        }
    }
}
