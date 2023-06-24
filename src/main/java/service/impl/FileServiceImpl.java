package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.FileService;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readDataFromFile(String pathFile) {
        List<String> dataFileReader;
        try {
            dataFileReader = Files.readAllLines(Path.of(pathFile));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file by path: " + pathFile, e);
        }
        return dataFileReader;
    }

    @Override
    public void writeDataToFile(String path, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file by path:  " + path, e);
        }
    }
}
