package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.File;
import java.io.IOException;

public class CsvFileWriter implements FileWriter {
    @Override
    public boolean write(String path, String report) {
        File file = new File(path);
        try {
            file.createNewFile();
            java.io.FileWriter fileWriter = new java.io.FileWriter(file);
            fileWriter.write(report);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't create report file, " + e);
        }
        return true;
    }
}
