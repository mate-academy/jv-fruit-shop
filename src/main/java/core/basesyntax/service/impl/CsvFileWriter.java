package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;

public class CsvFileWriter implements FileWriter {
    @Override
    public boolean write(String path, String report) {
        File file = new File(path);
        try (java.io.FileWriter fileWriter = new java.io.FileWriter(file);) {
            file.createNewFile();
            fileWriter.write(report);

        } catch (IOException e) {
            throw new RuntimeException("Can't create report file, " + e);
        }
        return true;
    }
}
