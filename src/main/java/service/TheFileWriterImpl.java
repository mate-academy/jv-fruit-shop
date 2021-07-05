package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TheFileWriterImpl implements TheFileWriter {

    @Override
    public void writeToFile(String report, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.append(report);
        } catch (IOException e) {
            throw new RuntimeException("can`t write to this file - " + fileName);
        }
    }
}
