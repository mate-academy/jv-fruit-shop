package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterService {
    public void write(String data,String fileName) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + fileName, e);
        }
    }
}
