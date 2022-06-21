package core.basesyntax.service.impl;

import core.basesyntax.service.CustomFileWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCsv implements CustomFileWriter {
    @Override
    public void writeFile(String filePath, String text) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't write report to the file " + filePath, e);
        }
    }
}
