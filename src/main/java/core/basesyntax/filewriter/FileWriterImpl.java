package core.basesyntax.filewriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriterInt {
    @Override
    public void write(String report, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка записи файла: " + filePath, e);
        }
    }
}
