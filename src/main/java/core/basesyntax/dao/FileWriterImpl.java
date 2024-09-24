package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Map;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeFile(String fileName, Map<String, Integer> inventory) {
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bw.write("fruit,quantity");
            bw.newLine();

            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file " + fileName, e);
        }
    }
}
