package core.basesyntax.service.implementation;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public boolean write(String report, String fileName) {
        File file = new File(fileName);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(file))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to " + fileName, e);
        }
        return true;
    }
}
