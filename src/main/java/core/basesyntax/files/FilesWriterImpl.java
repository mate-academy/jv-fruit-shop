package core.basesyntax.files;

import java.io.FileWriter;

public class FilesWriterImpl implements FilesWriter {
    private final String filePath;
    public FilesWriterImpl(String filePath) {
            this.filePath = filePath;
        }
        @Override
        public void writing(String report) {
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(report);
            } catch (Exception e) {
                throw new RuntimeException("Can't read from file " + filePath, e);
            }
        }
    }
