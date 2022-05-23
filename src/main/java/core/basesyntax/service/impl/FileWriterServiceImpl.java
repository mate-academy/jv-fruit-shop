package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String pathFile, String lines) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathFile))) {
            bufferedWriter.write(lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + pathFile, e);
        }
    }
}
