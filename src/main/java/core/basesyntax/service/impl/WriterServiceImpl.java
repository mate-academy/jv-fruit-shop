package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(List<String> list, String destinationFile) {
        File file = new File(destinationFile);
        for (String eachString : list) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));) {
                bufferedWriter.write(eachString + System.lineSeparator());
            } catch (IOException e) {
                throw new RuntimeException("Can't write data into file", e);
            }
        }
    }
}
