package core.basesyntax.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class WriterServiceImpl implements WriterService {
    @Override
    public void fileWriter(String fileName, List<String> lines) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName)))) {
            for (String element : lines) {
                writer.println(element);
            }
        } catch (IOException e) {
            System.err.println("Error when writing to the file: " + fileName);
        }
    }
}
