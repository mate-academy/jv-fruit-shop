package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriteService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class FileWriteServiceImpl implements FileWriteService {
    @Override
    public boolean writeFile(Map<String, Integer> fruits) {

        Set<Map.Entry<String, Integer>> entries = fruits.entrySet();
        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            if (fruits.isEmpty()) {
                throw new IllegalArgumentException();
            }
            for (Map.Entry<String, Integer> entry : entries) {
                fileWriter.write(entry.getKey() + ", " + entry.getValue() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to create file");
        }
        return true;
    }
}
