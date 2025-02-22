package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements CsvFileWriter {

    @Override
    public void writeFile(String fileName, String content) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(content);
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file " + fileName, e);
        }
    }
}
