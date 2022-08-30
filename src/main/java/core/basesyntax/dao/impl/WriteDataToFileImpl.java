package core.basesyntax.dao.impl;

import core.basesyntax.dao.WriteDataToFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class WriteDataToFileImpl implements WriteDataToFile {
    @Override
    public void writeDataToFile(Map<String, Integer> map, String path) {
        StringBuilder contentToWrite = new StringBuilder();
        contentToWrite.append("fruit,quantity")
                .append(System.lineSeparator())
                .append("banana,")
                .append(map.get("banana"))
                .append(System.lineSeparator())
                .append("apple,")
                .append(map.get("apple"));

        File file = new File(path);
        try {
            Files.write(file.toPath(), contentToWrite.toString().getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Cant write content to file " + e);
        }
    }
}
