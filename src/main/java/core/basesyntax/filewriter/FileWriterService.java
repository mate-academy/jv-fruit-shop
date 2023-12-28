package core.basesyntax.filewriter;

import java.io.FileWriter;

public class FileWriterService implements WriterService {
    @Override
    public void writeToFile(String report, String filePath) {
        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(report);
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }
    }
}
