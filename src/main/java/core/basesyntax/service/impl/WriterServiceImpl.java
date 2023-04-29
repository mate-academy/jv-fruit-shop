package core.basesyntax.service.impl;

import core.basesyntax.service.WriterService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String path, Map<String, Integer> data) {
        File file = new File(path);
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("fruit,quantity");
            for (Map.Entry<String, Integer> entry : data.entrySet()) {
                writer.write("\n" + entry.getKey() + "," + entry.getValue());
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file: " + path);
        }
    }
}
