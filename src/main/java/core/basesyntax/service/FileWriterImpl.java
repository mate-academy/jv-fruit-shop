package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void writeToFile(String fileName, String text) {
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(new File(fileName)))) {
            bw.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + fileName, e);
        }
    }
}
