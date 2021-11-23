package service.impl;

import service.MyWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MyWriterImpl implements MyWriter {
    @Override
    public void writeToFile( List<String> report, String filePath) {
        try {
            Files.write(Path.of(filePath), report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write data to file" + filePath, e);
        }
    }
}
