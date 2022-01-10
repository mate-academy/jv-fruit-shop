package core.basesyntax.service.impl;

import core.basesyntax.service.WriteFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WriteFileImpl implements WriteFile {
    @Override
    public void writeToFile(List<String> list, String fileName) {

        try {
            Files.write(Path.of(fileName), list);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + fileName, e);
        }
    }
}
