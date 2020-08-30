package core.basesyntax.fileservice;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriter {
    public void writeToFile(Map<String,Integer> fruitDao, String filePath) {
        try (BufferedWriter printer = new BufferedWriter(new java.io.FileWriter(filePath))) {
            printer.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> item : fruitDao.entrySet()) {
                printer.write(item.getKey() + "," + item.getValue().toString() + '\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with writing to file", e);
        }
    }
}
