package service.impl;

import db.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import model.Fruit;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void write(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write("fruit,quantity");
            bufferedWriter.newLine();
            for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
                bufferedWriter.write(entry.getKey().getName() + "," + entry.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file : " + filePath);
        }
    }
}
