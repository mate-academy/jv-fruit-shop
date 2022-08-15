package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToCsvFile(String text, String path) {
        String header = new StringBuilder().append("fruit,quantity")
                .append(System.lineSeparator()).toString();
        File myFile = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(myFile))) {
            bufferedWriter.write(header);
            bufferedWriter.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can't write the file " + path, e);
        }
    }
}
