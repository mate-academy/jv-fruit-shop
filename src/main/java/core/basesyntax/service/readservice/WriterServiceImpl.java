package core.basesyntax.service.readservice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String toWrite, String path) {
        if (toWrite == null || path == null) {
            throw new RuntimeException("Value can't be null");
        }
        File file = new File(path);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(toWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + toWrite, e);

        }
    }
}
