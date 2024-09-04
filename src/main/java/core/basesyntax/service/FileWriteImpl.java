package core.basesyntax.service;

import core.basesyntax.service.impl.FileWrite;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriteImpl implements FileWrite {
    @Override
    public void write(String result, String nameFileWrite) {
        try {
            Files.write(Paths.get(nameFileWrite), result.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cant write file " + nameFileWrite, e);
        }

    }
}
