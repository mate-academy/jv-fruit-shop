package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    private static final String FILE_PATH = "dataTxt/report.txt";

    @Override
    public void writeToFile(String data) {
        File file = new File(FILE_PATH);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data); // do something with the file we've opened
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
