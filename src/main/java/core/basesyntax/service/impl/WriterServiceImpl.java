package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {

    @Override
    public void writeToFile(String filepath, String data) {
        File file = new File(filepath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data); // do something with the file we've opened
        } catch (IOException e) {
            throw new RuntimeException("File not found: " + filepath, e);
        }
    }
}
