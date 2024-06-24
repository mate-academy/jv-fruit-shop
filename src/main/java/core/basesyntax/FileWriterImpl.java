import java.io.BufferedWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWriterImpl implements FileWriter {
    private static final Logger LOGGER = Logger.getLogger(FileWriterImpl.class.getName());

    @Override
    public void write(String data, String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "Error writing to file: " + filePath, e);
        }
    }
}
