package core.basesyntax.service.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String data, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file: ", e);
        }
    }
}