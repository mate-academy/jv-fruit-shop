package core.basesyntax.services.impl;

import core.basesyntax.services.WriteFileService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteFileServiceImpl implements WriteFileService {
    @Override
    public void writeToFile(Map<String, Integer> resultStore, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("fruit,quantity");
            for (Map.Entry<String, Integer> entry : resultStore.entrySet()) {
                writer.write("\n" + entry.getKey() + "," + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Cant write the data to the file " + fileName);
            e.printStackTrace();
        }
    }
}
