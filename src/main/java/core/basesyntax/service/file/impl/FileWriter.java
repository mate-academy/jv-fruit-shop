package core.basesyntax.service.file.impl;

import core.basesyntax.service.file.DataWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

public class FileWriter implements DataWriter {
    @Override
    public void writeToFile(List<String> report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            for (String row: report) {
                bufferedWriter.write(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("File was not found");
        }
    }
}
