package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import service.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String fileName) {
        File file = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write into the file " + file.getPath());
        }
    }
}
