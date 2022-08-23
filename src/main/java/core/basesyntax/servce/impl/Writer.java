package core.basesyntax.servce.impl;

import core.basesyntax.servce.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Writer implements FileWriter {
    @Override
    public void writeToFile(String data) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(REPORT_FILE_NAME))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + REPORT_FILE_NAME, e);
        }
    }
}
