package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.WriteFileService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteFileServiceImpl implements WriteFileService {
    private static final String COMMA = ",";

    @Override
    public boolean writeToFile(Storage fruitDB, String fileName) {
        Map<String, Integer> resultStore = fruitDB.getStorageFruits();
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("fruit,quantity");
            for (Map.Entry<String, Integer> entry : resultStore.entrySet()) {
                writer.write(System.lineSeparator() + entry.getKey() + COMMA + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Cant write the data to the file " + fileName);
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
