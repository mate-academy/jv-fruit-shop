package core.basesyntax.service.file;

import core.basesyntax.exception.FileWriteException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String data, String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(data);
        } catch (IOException e) {
            throw new FileWriteException("Cannot write to file: " + path);
        }
    }
}
