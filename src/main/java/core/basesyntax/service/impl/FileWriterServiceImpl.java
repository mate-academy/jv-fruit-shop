package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String fileName, List<String> report) {
        File file = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : report) {
                writer.write(line + System.lineSeparator());
            }
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file: " + fileName + e);
        }
    }
}
