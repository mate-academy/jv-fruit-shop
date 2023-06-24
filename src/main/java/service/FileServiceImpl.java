package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> readFromFile(String filePath) {
        List<String> listOfValues;
        try {
            listOfValues = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file " + filePath, e);
        }
        return listOfValues;
    }

    @Override
    public void writeToFile(String filesToWrite, String outFilePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFilePath))) {
            bufferedWriter.append(filesToWrite);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + outFilePath, e);
        }
    }
}
