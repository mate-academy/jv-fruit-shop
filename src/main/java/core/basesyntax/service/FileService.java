package core.basesyntax.service;

import java.io.File;
import java.io.IOException;

public class FileService {
    public void createBlankFile(String outputPath) {
        File serviceOutput = new File(outputPath);
        try {
            serviceOutput.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a new file", e);
        }
    }
}
