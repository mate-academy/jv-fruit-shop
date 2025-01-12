package core.basesyntax.fao;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriterMy {
    @Override
    public void write(String fileName,String info) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(info);
        } catch (IOException e) {
            throw new RuntimeException("Impossible to write in this file " + fileName);
        }
    }
}
