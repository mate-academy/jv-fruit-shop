package core.basesyntax.service.impl;

import core.basesyntax.service.WriteToCsvFileService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToCsvFileServiceImpl implements WriteToCsvFileService {
    private static final String FILE_NAME = "report.csv";
    @Override
    public void write(String report) {
        File file = new File(FILE_NAME);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a file ", e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file", e);
        }
    }
}
