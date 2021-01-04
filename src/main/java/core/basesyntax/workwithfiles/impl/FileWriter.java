package core.basesyntax.workwithfiles.impl;

import core.basesyntax.workwithfiles.DataWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter implements DataWriter {
    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("File was not found");
        }
    }
}
