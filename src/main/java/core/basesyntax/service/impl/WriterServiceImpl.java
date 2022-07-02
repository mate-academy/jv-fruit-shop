package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(List<String> list, String toFilePath) {
        File outputFile = new File(toFilePath);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            for (String s : list) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
