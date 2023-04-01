package service;

import static db.Storage.fruits;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterCsvImpl implements FileWriterService {
    private static final String HEADER_FRUIT = "fruitTransaction,";
    private static final String HEADER_QUANTITY = "quantity";

    @Override
    public void fileWriter(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(HEADER_FRUIT);
            bufferedWriter.write(HEADER_QUANTITY);
            bufferedWriter.newLine();
            for (Map.Entry<String, Integer> map : fruits.entrySet()) {
                bufferedWriter.write(map.getKey() + " " + map.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException exception) {
            throw new RuntimeException("System can't write data to the file: " + filePath);
        }
    }
}
