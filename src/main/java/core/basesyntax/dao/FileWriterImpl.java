package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FileWriterImpl implements CsvFileWriter {
    private static final Logger logger = LogManager.getLogger(FileWriterImpl.class);
    private static final String DEFAULT_OUTPUT_FILE = "output/finalReport.csv";

    @Override
    public void writeFile(String fileName, String content) {
        Path filePath = Paths.get(fileName == null
                || fileName.isBlank() ? DEFAULT_OUTPUT_FILE : fileName);

        try {
            Files.createDirectories(filePath.getParent());

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath.toFile()))) {
                bw.write(content);
                logger.info("Report successfully written to: " + filePath);
            }
        } catch (IOException e) {
            logger.error("Error writing to file: " + filePath,e);
            throw new RuntimeException("Error writing to file " + filePath, e);
        }
    }
}
