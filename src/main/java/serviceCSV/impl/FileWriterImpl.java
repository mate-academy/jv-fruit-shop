package serviceCSV.impl;

import serviceCSV.FileWriterService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriterService {

    @Override
    public void writeToFile(String pathName, String data) {
        File file = new File(pathName);
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file correctly.", e);
        }
    }
}
