package servise.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import servise.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeStringToFile(String filePath, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file" + filePath, e);
        }
    }
}
