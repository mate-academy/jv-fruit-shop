package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriterService {
    @Override
    public void writeToFile(String fileName, String report) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter(fileName))) {
            bf.write(report);
        } catch (IOException e) {
            throw new RuntimeException("You can not write to file " + fileName, e);
        }
    }
}
