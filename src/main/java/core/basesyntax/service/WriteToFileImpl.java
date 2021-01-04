package core.basesyntax.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class WriteToFileImpl implements WriteToFile {
    @Override
    public void write(String fileName, Map<String, Integer> shop) {
        String result = new CombineStringFromMapImpl().combineString(shop);
        try {
            Files.writeString(new File(fileName).toPath(), result);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
