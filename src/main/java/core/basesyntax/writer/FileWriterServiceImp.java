package core.basesyntax.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterServiceImp implements FileWriterService {
    @Override
    public void writeFile(String report, String nameFile) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(nameFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file: " + nameFile, e);
        }
    }
}
