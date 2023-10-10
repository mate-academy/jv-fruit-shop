package fruit.shop.service.impl;

import fruit.shop.service.Reader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderImpl implements Reader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> data;
        try {
            data = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("File not found " + fileName,e);
        }
        return data;
    }
}
