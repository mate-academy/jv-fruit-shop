package core.basesyntax.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class FileReaderImpl implements FileReader {
    private static final Logger logger = LogManager.getLogger(FileReaderImpl.class);
    private static final String DEFAULT_INPUT_FILE = "reportToRead.csv";

    @Override
    public List<String> readFile(String fileName) {
        String filePath = getResourceFilePath(fileName == null
                || fileName.isBlank() ? DEFAULT_INPUT_FILE : fileName);
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Path.of(filePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            logger.info("Successfully read file: " + filePath);
        } catch (IOException e) {
            logger.error("Error while reading file: " + filePath, e);
            throw new RuntimeException("Error while reading file " + filePath, e);
        }
        return lines;
    }

    private String getResourceFilePath(String fileName) {
        return Path.of(ClassLoader.getSystemResource(fileName).getPath()).toString();
    }
}
