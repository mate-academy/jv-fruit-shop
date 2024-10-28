package core.basesyntax.WorkWithFile;
import core.basesyntax.WorkWithFileInterface.FileWriter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String report, String fileName) {
        try {
            Files.write(Paths.get(fileName), report.getBytes());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
            e.printStackTrace();
        }
    }
}
