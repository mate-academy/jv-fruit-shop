package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final String EXCEPTION_MESSAGE = "Can't read date from current file";

    @Override
    public List<String> read(String pathName) {
        List<String> dataFromInputFile;
        try {
            dataFromInputFile = Files.readAllLines(new File(pathName).toPath());
        } catch (IOException e) {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
        return dataFromInputFile;
    }
}
