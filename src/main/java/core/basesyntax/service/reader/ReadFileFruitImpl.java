package core.basesyntax.service.reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ReadFileFruitImpl implements ReadFileFruit {
    @Override
    public List<String> readAll(String filePath) {
        if (filePath == null || filePath.isBlank()) {
            throw new RuntimeException("Input file path must not be null or blank");
        }
        List<String> list = new LinkedList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file by path: " + filePath, e);
        }
        return list;
    }
}
