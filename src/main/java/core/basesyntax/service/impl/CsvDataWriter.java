package core.basesyntax.service.impl;

import core.basesyntax.service.DataWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class CsvDataWriter implements DataWriter {
    private static final String EXCEPTION_MESSAGE = "Can't write to file";

    public void writeToFile(String destinationFileName, String reportData) {
        File destinationfile = new File(destinationFileName);
        try {
            Files.write(destinationfile.toPath(), reportData.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + destinationFileName, e);
        }
    }
}
