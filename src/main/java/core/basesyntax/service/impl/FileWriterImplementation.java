package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImplementation implements FileWriterService {
    @Override
    public void write(String data, String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            bufferedWriter.append(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName);
        }

    }
}
