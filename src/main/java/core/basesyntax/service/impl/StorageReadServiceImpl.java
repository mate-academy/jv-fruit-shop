package core.basesyntax.service.impl;

import core.basesyntax.service.StorageReadService;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class StorageReadServiceImpl implements StorageReadService {
    private static final String EXCEPTION_MESSAGE = "Can't read this file ";

    @Override
    public List<String> readData(String filePath) {
        File file = new File(filePath);
        List<String> dataFromFile;
        try {
            dataFromFile = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE + file);
        }
        return dataFromFile;
    }
}
