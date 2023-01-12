package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteToFileImpl implements WriteToFile {
    public void writeToFile(String report, String toFileName) {
        try {
            Files.writeString(Paths.get(toFileName), report);
        } catch (IOException e) {
            throw new RuntimeException("Can't find file " + toFileName, e);
        }
    }
}
