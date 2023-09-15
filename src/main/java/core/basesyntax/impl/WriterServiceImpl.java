package core.basesyntax.impl;

import core.basesyntax.service.util.WriterServise;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterServise {
    @Override
    public void writeToFile(List<String> content, String fileName) {
        for (String line : content) {
            try (BufferedWriter bufferedWriter
                         = new BufferedWriter(new FileWriter(fileName, true))) {
                bufferedWriter.write(line);
                bufferedWriter.write(System.lineSeparator());

            } catch (IOException e) {
                throw new RuntimeException("Can't write report to file: " + fileName, e);
            }
        }
    }
}
