package service;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public boolean write(String data, String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(path))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("The writing path is not correct.");
        }
        return true;
    }
}
