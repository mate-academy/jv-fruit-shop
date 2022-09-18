package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {
    private static final String FIRST_LINE_REPORT = "fruit,quantity";

    @Override
    public void writeToFile(String path, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(path)))) {
            bufferedWriter.write(FIRST_LINE_REPORT);
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write the file" + path, e);
        }
    }
}
