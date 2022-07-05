package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String filePath, List<String> lines) {
        File toFile = new File(filePath);
        try (BufferedWriter bufferedWriter
                    = new BufferedWriter(new java.io.FileWriter(toFile, true))) {
            for (int i = 0; i < lines.size(); i++) {
                bufferedWriter.write(lines.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException("Write error to file " + filePath + "!", e);
        }
    }
}
