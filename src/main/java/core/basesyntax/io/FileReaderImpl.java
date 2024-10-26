package core.basesyntax.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReaderImpl implements FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReaderImpl.class.getName());

    public List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to read from file: " + fileName, e);
        }
        return lines;
    }
}
