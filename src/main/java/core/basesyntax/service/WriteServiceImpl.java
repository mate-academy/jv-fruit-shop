package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceImpl implements WriteService {

    @Override
    public void writeFile(String filePath, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter((filePath)))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file: " + filePath, e);
        }
    }
}
