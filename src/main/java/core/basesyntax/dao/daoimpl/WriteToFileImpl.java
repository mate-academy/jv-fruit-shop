package core.basesyntax.dao.daoimpl;

import core.basesyntax.dao.WriteToFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void writeToFile(String report, String toFile) {
        try {
            Files.writeString(Path.of(toFile), report);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + toFile, e);
        }
    }
}
