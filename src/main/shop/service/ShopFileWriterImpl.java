package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ShopFileWriterImpl implements ShopFileWriter{
    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + fileName, e);
        }
    }
}
