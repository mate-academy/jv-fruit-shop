package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileWriterServiceImpl implements FileWriterService {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void write(String data, String fileName) {
        File file = new File(fileName);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(data);
            logger.info("Report successfully written to {}", fileName);
        } catch (IOException e) {
            logger.error("Error writing to file: {}", fileName, e);
            throw new RuntimeException("Error writing to file: " + fileName, e);
        }
    }
}
