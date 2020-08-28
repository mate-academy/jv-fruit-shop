package core.basesyntax.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class WriteFileServiceImpl implements WriteFileService {
    @Override
    public void writeFile(Map<String, Integer> fruitStorage) {
        Set<Map.Entry<String, Integer>> entries = fruitStorage.entrySet();
        try (FileWriter fileWriter = new FileWriter("src/resources/fruits_out.csv")) {
            fileWriter.write("fruit, quantity" + "\n");
            for (Map.Entry<String, Integer> entry : entries) {
                fileWriter.write(entry.getKey() + ", " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file");
        }
    }
}
