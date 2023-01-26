package core.basesyntax.impl;

import core.basesyntax.services.WriteService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeToFile(String toFilePath, String report) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(
                new FileWriter(report))) {
            bufferedWriter.write(toFilePath);
        } catch (IOException e) {
            throw new RuntimeException("Couldn`t write to file by " + toFilePath, e);
        }
    }
}
