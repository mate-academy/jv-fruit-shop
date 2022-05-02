package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriting;
import core.basesyntax.storage.Storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class FileWritingImpl implements FileWriting {

    @Override
    public void writeToFile(Path path) {
        StringBuilder exitFile = new StringBuilder("Fruit, quantity" + System.lineSeparator());
        for (Map.Entry<String, Integer> fruit: Storage.fruitStorage.entrySet()) {
            exitFile.append(fruit.getKey())
                    .append(",")
                    .append(fruit.getValue())
                    .append(System.lineSeparator());
        }
        String report = exitFile.toString();

        try {
            Files.writeString(Path.of("src/main/resources/report.csv"), report);
        } catch (IOException e) {
            throw new RuntimeException("Writing file failed" + path, e);
        }
    }
}
