package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
                writer.write("");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Cant write data to file", e);
        }
    }
}
