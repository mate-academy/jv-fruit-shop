package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class CsvWriter implements FileWriter {
    @Override
    public void write(String data, String pathname) {
        if (data == null || data.isEmpty()) {
            throw new IllegalArgumentException("Data can not be empty!");
        }

        File file = new File(pathname);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.write(data);
        } catch (IOException ex) {
            throw new RuntimeException("Can't write to file", ex);
        }
    }
}
