package core.fruitshop.services.impl;

import core.fruitshop.services.FileWorker;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class FileWorkerImpl implements FileWorker {
    @Override
    public List<String> readFromFile(String fileName) {
        try {
            List<String> strings = Files.readAllLines(Paths.get(fileName));
            System.out.println("Successfully read data from " + fileName);
            return strings;
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong when reading from file " + fileName);
        }
    }

    @Override
    public void writeToFile(String fileName, String header, String columnSeparator, Map<String, Integer> data) {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            writer.write(header);
            writer.newLine();
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                writer.write(entry.getKey() + columnSeparator + entry.getValue());
                writer.newLine();
            }
            System.out.println("Successfully wrote data to " + fileName);
        } catch (IOException exception) {
            throw new RuntimeException("Something went wrong when writing to file " + fileName);
        }
    }
}
