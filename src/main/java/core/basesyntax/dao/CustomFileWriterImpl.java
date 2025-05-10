package core.basesyntax.dao;

import java.io.BufferedWriter;
import java.io.IOException;

public class CustomFileWriterImpl implements CustomFileWriter {
    @Override
    public void write(String fileName,String info) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(info);
        } catch (IOException e) {
            throw new RuntimeException("Can't write file with path:" + fileName, e);
        }
    }
}
