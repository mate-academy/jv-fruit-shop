package core.basesyntax.io;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomFileWriterImpl implements CustomFileWriter {
    private static final Logger LOGGER = Logger.getLogger(CustomFileWriterImpl.class.getName());

    public void write(String content, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bw.write(content);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Failed to write to file: " + fileName, e);
        }
    }
}
