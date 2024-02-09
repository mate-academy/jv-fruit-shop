package service.impl;

import java.io.FileWriter;
import java.io.IOException;
import service.Writer;

public class FruitCsvWriter implements Writer {
    private static final String PATH_TO_WRITE = "src/main/resources/FruitReport.csv";

    @Override
    public void write(String file) {
        try {
            FileWriter fileWriter = new FileWriter(PATH_TO_WRITE);
            fileWriter.write(file);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Can't write this file" + file);
        }

    }
}
