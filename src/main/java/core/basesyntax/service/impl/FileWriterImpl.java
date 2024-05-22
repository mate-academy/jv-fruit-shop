package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    private static final String PATH_TO_RESOURCES = "src/main/resources/";
    private static final String FILE_FORMAT = ".csv";

    @Override
    public void write(String text, String fileName) {
        try {
            Files.write(Paths.get(PATH_TO_RESOURCES + fileName + FILE_FORMAT), text.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can't write a report" + e);
        }
    }
}
