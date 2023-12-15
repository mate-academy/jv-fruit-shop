package core.basesyntax.fileWriter;

import java.io.FileWriter;
public class FileWriterService {
    public void writeToFile(String report, String filePath) {
        try {
            FileWriter fileWriter = new FileWriter(filePath);
            fileWriter.write(report);
            fileWriter.close();
        } catch (Exception e) {
            throw new RuntimeException("Can't write to file " + filePath, e);
        }

    }
}
