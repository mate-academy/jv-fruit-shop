package core.basesyntax.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String toWrite, String pathToFile) {
        if (toWrite == null || pathToFile == null) {
            throw new RuntimeException("Input doesn`t have to be null");
        }
        File file = new File(pathToFile);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(toWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + toWrite, e);
        }
    }
}
