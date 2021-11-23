package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    public boolean writeData(String toFilePath, String data) {
        File file = new File(toFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, false))) {
            bufferedWriter.write(data);
            return true;
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file!", e);
        }
    }
}
