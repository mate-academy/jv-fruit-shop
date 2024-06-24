package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import service.WriterService;

public class WriterServiceImpl implements WriterService {
    @Override
    public void write(String data, String toFileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + toFileName, e);
        }
    }
}
