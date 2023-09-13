package fruitshop.sevice.impl;

import fruitshop.sevice.FileReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderSeviceImpl implements FileReaderService {

    @Override
    public List<String> readFromFile(String fromFileName) {
        List<String> linesFromFile = new ArrayList<>();
        Path path = Paths.get(fromFileName);
        try {
            Files.lines(path).skip(1).forEach(linesFromFile::add);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + fromFileName);
        }
        return linesFromFile;
    }
}
