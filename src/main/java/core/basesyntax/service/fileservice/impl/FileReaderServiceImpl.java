package core.basesyntax.service.fileservice.impl;

import core.basesyntax.service.fileservice.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderServiceImpl extends FileReaderService {

    @Override
    public List<String> getData(String path) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(path))) {
            return fileReader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Can`t raed from file: " + path);
        }
    }
}
