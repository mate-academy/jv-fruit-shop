package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriterServiceImpl implements WriterService {
    @Override
    public void writeToFile(String toFile, String report) {
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + toFile, e);
        }
    }
}
