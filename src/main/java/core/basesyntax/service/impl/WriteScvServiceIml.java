package core.basesyntax.service.impl;

import core.basesyntax.service.WriteScvService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class WriteScvServiceIml implements WriteScvService {
    @Override
    public void writeDataScvFile(String data, String filePath) {
        try {
            Files.writeString(new File(filePath).toPath(), data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
