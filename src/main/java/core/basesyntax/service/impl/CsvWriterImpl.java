package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CsvWriterImpl implements FileWriter {
    private static final String FILE_PATH = "src/main/resources/";

    @Override
    public void writeTo(String fromString, String toFilePath) {

        if (fromString == null || fromString.isEmpty()) {
            throw new
                    RuntimeException("String from which should be written from is empty: "
                    + fromString);
        }

        if (toFilePath == null || toFilePath.isEmpty()) {
            throw new
                    RuntimeException("The File Path that should be written to is empty: "
                    + toFilePath);
        }

        File csvOutputFile = new File(FILE_PATH + toFilePath);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pw.write(fromString);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not create or write to file: " + toFilePath, e);
        }
    }
}
