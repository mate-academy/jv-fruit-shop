package service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public void writeToFile(String report, String outputFilePath) {
        File writeToFile = new File(outputFilePath);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(writeToFile))) {
            bufferedWriter.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Can't write any information to the file! "
                    + outputFilePath + " " + e);
        }
    }
}
