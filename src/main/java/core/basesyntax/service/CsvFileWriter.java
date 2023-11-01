package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;

public class CsvFileWriter implements FileWriter {
    private static final String EXCEPTION_MSG = "Can't write to file ";

    @Override
    public boolean write(String content, String toFileName) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new java.io.FileWriter(toFileName))) {
            bufferedWriter.write(content);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MSG + toFileName, e);
        }
    }
}
