package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String content, String fileName) {
        try {
            Files.writeString(Path.of(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException("Cant be save to file",e);
        }

    }
}
