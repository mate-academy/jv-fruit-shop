package core.basesyntax.impl;

import core.basesyntax.service.WriteToFile;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void writeReport(String path, Map<String, Integer> map) {
        BufferedWriter writer = null;
        File file = new File(path);
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + e);
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
