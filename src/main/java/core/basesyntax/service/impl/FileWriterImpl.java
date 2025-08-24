package core.basesyntax.service.impl;

import static core.basesyntax.Main.FILE_PATH_OUTPUT_FILE;

import core.basesyntax.service.CustomFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements CustomFileWriter {
    public void write(String resultingReport) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(FILE_PATH_OUTPUT_FILE))) {
            bufferedWriter.write(resultingReport);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file", e);
        }
    }
}
