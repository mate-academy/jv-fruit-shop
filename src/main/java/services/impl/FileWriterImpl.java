package services.impl;

import java.io.BufferedWriter;
import java.io.IOException;
import services.interfaces.FileWriter;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String filePath, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + filePath, e);
        }

    }
}
