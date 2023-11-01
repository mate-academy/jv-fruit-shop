package service.impl;

import db.Storage;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Writer {
    public void write(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("fruit,quantity");
            writer.newLine();

            Map<String, Integer> fruitsAndAmount = Storage.getFruitsAndAmount();

            for (Map.Entry<String, Integer> entry : fruitsAndAmount.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file");
        }
    }
}

