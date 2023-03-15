package service.impl;

import service.WriterData;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CsvFileWriterService implements WriterData {
    @Override
    public void write(String report, String path) {
        File file = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file));){
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + e);
        }
    }
}
