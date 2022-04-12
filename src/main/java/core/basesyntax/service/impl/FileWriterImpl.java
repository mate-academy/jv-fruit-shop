package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ListIterator;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeLines(String filePath, List<String> records) {
        Path path = new File(filePath).toPath();
        try {

            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            Files.writeString(path, records.get(0));
            ListIterator<String> iterator = records.listIterator(1);
            while (iterator.hasNext()) {
                String separateLine = System.lineSeparator() + iterator.next();
                Files.writeString(path, separateLine, StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            throw new RuntimeException("Cant write to file " + filePath, e);
        }
    }
}
