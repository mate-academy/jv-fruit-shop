package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {

    @Override
    public void writeReport(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data" + filePath);
        }

    }
}
