package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String data, String toFile) {
        File outputFile = new File(toFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to the file:" + toFile, e);
        }
    }
}
