package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    private static final String PATH_TO_OUTPUT_FILE = "src/main/resources/";

    @Override
    public void writeToFile(String fileName, String report) {
        File file = new File(PATH_TO_OUTPUT_FILE + fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file",e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file", e);
        }
    }
}
