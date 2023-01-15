package service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFileImpl implements WriteToFile {

    @Override
    public void writeToFile(String filePath, String listOfValues) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));
            bufferedWriter.append(listOfValues);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to the file " + filePath);
        }
    }
}
