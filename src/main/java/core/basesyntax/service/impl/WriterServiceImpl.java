package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String pathToFile, String data) {
        File file = new File(pathToFile);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            file.createNewFile();
            writer.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file on the path "
                    + pathToFile, e);
        }
    }
}
