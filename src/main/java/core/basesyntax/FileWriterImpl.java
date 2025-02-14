package core.basesyntax;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriterMet {
    @Override
    public void writeToFile(String fileName, String text) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(new File(fileName)))) {
            bw.write(text);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file " + fileName, e);
        }
    }
}
