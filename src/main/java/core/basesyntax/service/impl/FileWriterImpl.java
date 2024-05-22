package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriter;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String text, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new java.io.FileWriter(filePath))) {
            bw.write(text);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Can't write data to file" + filePath, ex);
        } catch (IOException ex) {
            throw new RuntimeException("IOException has happened in the file" + filePath, ex);
        }
    }
}
