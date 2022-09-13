package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String inputReport, String destinationPath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationPath))) {
            bufferedWriter.write(inputReport);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + destinationPath);
        }
    }
}
