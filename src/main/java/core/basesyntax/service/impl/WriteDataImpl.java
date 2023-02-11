package core.basesyntax.service.impl;

import core.basesyntax.service.WriteData;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteDataImpl implements WriteData {
    @Override
    public void writeToFile(String report, String filePath) {
        File file = new File(filePath);
        try {
            file.createNewFile();
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to write file: " + filePath
                    + " to file: " + report);
        }
    }
}
