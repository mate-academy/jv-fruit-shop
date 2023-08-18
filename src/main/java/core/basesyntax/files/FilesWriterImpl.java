package core.basesyntax.files;

import java.io.FileWriter;

public class FilesWriterImpl implements FilesWriter {
    @Override
        public void writeToFile(String filePath, String data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        } catch (Exception e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }
}
