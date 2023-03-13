package core.basesyntax.service.impl;

import static core.basesyntax.db.Storage.getFruitShop;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class CsvWriter {
    private static final String PATH = "src/main/java/core/basesyntax/Result.csv";

    private BufferedWriter writer;

    public void writeToCsvFile() {
        {
            try {
                writer = Files.newBufferedWriter(Path.of(PATH));
                for (Map.Entry<String, Integer> e : getFruitShop().entrySet()) {
                    writer.write(e.getKey() + "," + e.getValue());
                    writer.newLine();
                    writer.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException("Can't write to file", e);
            }
        }
    }
}
