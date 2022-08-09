package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.Reader;

public class ReaderImpl implements Reader {
    @Override
    public List<String> fileReader(String filePath) {
        List<String> dataShop;
        try {
            dataShop = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("File " + filePath + " cannot be read.", e);
        }
        return dataShop;
    }
}
