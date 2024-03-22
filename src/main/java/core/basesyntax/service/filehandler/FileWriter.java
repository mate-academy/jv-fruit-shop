package core.basesyntax.service.filehandler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriter {
    public void write(String filePath, String report) {
        File writeFile = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(writeFile))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("can't write to the file: " + filePath, e);
        }
    }
}
