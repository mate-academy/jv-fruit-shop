package service.impl;

import service.WriterService;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String pathToFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {

        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + pathToFile, e);
        }
    }
}
