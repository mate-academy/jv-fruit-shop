package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String toWrite, String toFile) {
        if (toWrite == null || toFile == null) {
            throw new RuntimeException("You shouldn't give null arguments");
        }
        File file = new File(toFile);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            bw.write(toWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + e);
        }
    }
}
