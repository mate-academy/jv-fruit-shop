package service;

import db.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteService {
    public void writeInFile(String pathTo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pathTo))) {
            writer.write("fruit,quantity" + System.lineSeparator());
            for (Map.Entry<String, Integer> entry : Storage.storage.entrySet()) {
                writer.write(new StringBuilder().append(entry.getKey()).append(",")
                        .append(String.valueOf(entry.getValue()))
                        .append(System.lineSeparator()).toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file ", e);
        }
    }
}
