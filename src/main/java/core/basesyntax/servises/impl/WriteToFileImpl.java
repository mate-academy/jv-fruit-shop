package core.basesyntax.servises.impl;

import core.basesyntax.servises.WriteToFile;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class WriteToFileImpl implements WriteToFile {
    private static final String SEPARATOR = System.getProperty("line.separator");
    private static final String COMMA = ",";
    private static final String CSV_START = "fruit,amount";

    @Override
    public void addToFile(String path, HashMap<String, Integer> storage) {
        try {
            try (Writer writer = new FileWriter(path)) {
                writer.append(CSV_START).append(SEPARATOR);
                for (Map.Entry<String, Integer> entry : storage.entrySet()) {
                    writer.append(entry.getKey())
                            .append(COMMA)
                            .append(String.valueOf(entry.getValue()))
                            .append(SEPARATOR);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException("Wrong path");
        }
    }
}
