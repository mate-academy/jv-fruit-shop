package core.basesyntax.service.impl;

import core.basesyntax.service.MyFileReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class MyFileReaderImpl implements MyFileReader {
    @Override
    public List<String> readFromFile(String fileName) {
        List<String> data = new ArrayList<>();
        File file = new File(fileName);
        try {
            data = Files.readAllLines(file.toPath());
            return data;
        } catch (IOException e) {
            throw new RuntimeException("Can`t reading from file : " + fileName + e);
        }
    }
}
