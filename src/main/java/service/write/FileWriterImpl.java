package service.write;

import static db.Storage.fruitQuantity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class FileWriterImpl implements FileWriter {

    @Override
    public String prepareToWrite() {
        StringBuilder result = new StringBuilder();
        result.append("fruit,quantity");
        Set<Map.Entry<String, Integer>> entries = fruitQuantity.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            result.append(System.lineSeparator()).append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return result.toString();
    }

    @Override
    public void write(String resultString, String pathToWrite) {
        File file = new File(pathToWrite);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.write(resultString);
        } catch (IOException e) {
            throw new RuntimeException("Can't write in file.");
        }
    }
}

