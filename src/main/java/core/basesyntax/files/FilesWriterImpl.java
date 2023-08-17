package core.basesyntax.files;

import java.io.FileWriter;

public class FilesWriterImpl implements FilesWriter {
    @Override
        public void writeToFile(String filePath,String report) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't read from file " + filePath, e);
        }
    }
}
