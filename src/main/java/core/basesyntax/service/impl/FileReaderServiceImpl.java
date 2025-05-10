package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileReaderServiceImpl implements FileReaderService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public List<String> readFile(String fileName) {
        try {
            return Files.readAllLines(new File(fileName).toPath());
        } catch (IOException e) {
            logger.error("Can't read file: {}", fileName, e);
            throw new RuntimeException("Can't read file: " + fileName, e);
        }
    }
}
