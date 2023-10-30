package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToCsvFileService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCsvFileServiceImpl implements WriteToCsvFileService {
    private final String fileName;

    public WriteToCsvFileServiceImpl(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void write(String report) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a file ", e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file", e);
        }
    }
}
