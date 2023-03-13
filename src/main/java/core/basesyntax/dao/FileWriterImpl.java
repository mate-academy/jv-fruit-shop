package core.basesyntax.dao;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    @Override
    public void write(String path, String report) {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path))) {
            byte[] buffer = report.getBytes();
            bos.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException("File not found " + e);
        }
    }
}
