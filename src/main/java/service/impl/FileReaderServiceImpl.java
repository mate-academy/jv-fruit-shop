package service.impl;

import exception.FruitShopException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import service.FileReaderService;

public class FileReaderServiceImpl implements FileReaderService {
    private static final int ANNOTATION_OFFSET = 1;

    @Override
    public List<String> read(String filePath) {
        List<String> dataFromFile;
        Path path = Paths.get(filePath);
        try {
            dataFromFile = Files.lines(path)
                    .skip(ANNOTATION_OFFSET)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new FruitShopException("Can't read data from file" + filePath);
        }
        return dataFromFile;
    }
}
