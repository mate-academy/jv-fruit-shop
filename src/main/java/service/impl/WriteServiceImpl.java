package service.impl;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriteServiceImpl implements WriterService {
    @Override
    public void writeTo(String pathToFile, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathToFile))) {
            writer.write(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("The file not found.", e);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to the file.", e);
        }
    }
}
