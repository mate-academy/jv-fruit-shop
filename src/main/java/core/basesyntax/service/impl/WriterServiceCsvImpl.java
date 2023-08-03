package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceCsvImpl implements WriterService {

    @Override
    public void writeToFile(List<String> list, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (String line : list) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + fileName, e);
        }
    }
}

